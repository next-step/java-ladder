package com.jaeyeonling.ladder;

import com.jaeyeonling.ladder.domain.ladder.HeightOfLadder;
import com.jaeyeonling.ladder.domain.ladder.LadderGame;
import com.jaeyeonling.ladder.domain.ladder.LadderGameGenerator;
import com.jaeyeonling.ladder.domain.ladder.LadderResults;
import com.jaeyeonling.ladder.domain.line.*;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.exception.NotEqualsUserSizeAndResultSizeException;
import com.jaeyeonling.ladder.view.ResultViewer;
import com.jaeyeonling.ladder.view.console.ConsoleInputView;

public class Application {

    private final LadderGameGenerator ladderGameGenerator;

    private Application(final LadderGameGenerator ladderGameGenerator) {
        this.ladderGameGenerator = ladderGameGenerator;
    }

    public static void main(final String... args) {
        final PointGenerateStrategy pointGenerateStrategy = new RandomPointGenerateStrategy();
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.withStrategy(pointGenerateStrategy);
        final LadderGameGenerator ladderGameGenerator = LadderGameGenerator.withLineGenerator(lineGenerator);

        final Application application = new Application(ladderGameGenerator);

        application.start();
    }

    private void start() {
        final Users users = Users.ofSeparator(ConsoleInputView.readUsers());
        final LadderResults ladderResults = LadderResults.ofSeparator(ConsoleInputView.readLadderResults());

        if (users.size() != ladderResults.size()) {
            throw new NotEqualsUserSizeAndResultSizeException(users.size(), ladderResults.size());
        }

        final HeightOfLadder heightOfLadder = HeightOfLadder.valueOf(ConsoleInputView.readLadderHeight());

        final LadderGame ladderGame = ladderGameGenerator.generate(users, heightOfLadder);

        final ResultViewer resultViewer = new ResultViewer(users, ladderGame, ladderResults);

        resultViewer.view();
    }
}
