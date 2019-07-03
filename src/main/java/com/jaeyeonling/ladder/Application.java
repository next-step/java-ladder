package com.jaeyeonling.ladder;

import com.jaeyeonling.ladder.domain.GameInfo;
import com.jaeyeonling.ladder.domain.GameResult;
import com.jaeyeonling.ladder.domain.ladder.*;
import com.jaeyeonling.ladder.domain.line.*;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.view.console.ConsoleInputView;
import com.jaeyeonling.ladder.view.console.ConsoleOutputView;
import com.jaeyeonling.ladder.view.format.Formatters;

import java.util.Objects;

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
        final LadderRewords ladderRewords = LadderRewords.ofSeparator(ConsoleInputView.readLadderRewords());

        final GameInfo gameInfo = GameInfo.withUsersAndLadderRewords(users, ladderRewords);
        final HeightOfLadder heightOfLadder = HeightOfLadder.valueOf(ConsoleInputView.readLadderHeight());

        final LadderGame ladderGame = ladderGameGenerator.generate(gameInfo, heightOfLadder);

        ConsoleOutputView.printLadderReword();
        ConsoleOutputView.print(Formatters.usersFormatter.format(users));
        ConsoleOutputView.print(Formatters.ladderGameFormatter.format(ladderGame));
        ConsoleOutputView.print(Formatters.ladderRewordsFormatter.format(ladderRewords));

        final GameResult gameResult = ladderGame.play();

        while (true) {
            final String usernameOfWantReword = ConsoleInputView.readUsernameOfWantReword();
            if (gameResult.isShowAll(usernameOfWantReword)) {
                showAll(gameResult);
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

        ConsoleOutputView.printResult();
        ConsoleOutputView.print(Formatters.ladderRewordFormatter.format(matchingReword));
    }

    private void showAll(final GameResult gameResult) {
        ConsoleOutputView.printResult();

        gameResult.stream()
                .forEach(rewordOfUsername -> {
                    final String username = rewordOfUsername.getKey();
                    final LadderReword ladderReword = rewordOfUsername.getValue();

                    final String formattedMatchingReword = Formatters.ladderRewordFormatter.format(ladderReword);
                    ConsoleOutputView.printMatchingReword(username, formattedMatchingReword);
                });
    }
}
