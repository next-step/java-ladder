package com.jaeyeonling.ladder;

import com.jaeyeonling.ladder.domain.GameResult;
import com.jaeyeonling.ladder.domain.ladder.*;
import com.jaeyeonling.ladder.domain.line.*;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.view.console.ConsoleInputView;
import com.jaeyeonling.ladder.view.console.ConsoleOutputView;

import java.util.Objects;

public class Application {

    private LinesFactory linesFactory;

    private Application(final LinesFactory linesFactory) {
        this.linesFactory = linesFactory;
    }

    public static void main(final String... args) {
        final PointGenerateStrategy pointGenerateStrategy = new RandomPointGenerateStrategy();
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.withStrategy(pointGenerateStrategy);
        final LinesFactory linesFactory = GeneratorBaseLinesFactory.withLineGenerator(lineGenerator);

        final Application application = new Application(linesFactory);

        application.start();
    }

    private void start() {
        final Users users = Users.ofSeparator(ConsoleInputView.readUsers());
        final LadderRewords ladderRewords = LadderRewords.ofSeparator(ConsoleInputView.readLadderRewords());
        final HeightOfLadder heightOfLadder = HeightOfLadder.valueOf(ConsoleInputView.readLadderHeight());

        final LadderGame ladderGame = LadderGameFactory.create(users, ladderRewords);
        ladderGame.initializeLines(heightOfLadder, linesFactory);

        ConsoleOutputView.printLadderReword(ladderGame);

        final GameResult gameResult = ladderGame.play();

        while (true) {
            final String usernameOfWantReword = ConsoleInputView.readUsernameOfWantReword();
            if (gameResult.isShowAll(usernameOfWantReword)) {
                ConsoleOutputView.printGameResult(gameResult);
                break;
            }

            showSingle(gameResult, usernameOfWantReword);
        }
    }

    private void showSingle(final GameResult gameResult,
                            final String usernameOfWantReword) {
        final LadderReword matchingReword = gameResult.findMatchingReword(usernameOfWantReword);
        if (Objects.isNull(matchingReword)) {
            ConsoleOutputView.printUserNotFound(usernameOfWantReword);
            return;
        }

        ConsoleOutputView.printSingleResult(matchingReword);
    }
}
