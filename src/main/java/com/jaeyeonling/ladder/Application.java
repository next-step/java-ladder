package com.jaeyeonling.ladder;

import com.jaeyeonling.ladder.domain.GameInfo;
import com.jaeyeonling.ladder.domain.ladder.HeightOfLadder;
import com.jaeyeonling.ladder.domain.ladder.LadderGame;
import com.jaeyeonling.ladder.domain.ladder.LadderGameGenerator;
import com.jaeyeonling.ladder.domain.ladder.LadderResults;
import com.jaeyeonling.ladder.domain.line.*;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Username;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.exception.NotFoundUserException;
import com.jaeyeonling.ladder.view.console.ConsoleInputView;
import com.jaeyeonling.ladder.view.console.ConsoleOutputView;
import com.jaeyeonling.ladder.view.format.Formatters;

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

        final GameInfo gameInfo = GameInfo.withUsersAndLadderResults(users, ladderResults);

        final HeightOfLadder heightOfLadder = HeightOfLadder.valueOf(ConsoleInputView.readLadderHeight());
        final LadderGame ladderGame = ladderGameGenerator.generate(users, heightOfLadder);

        ConsoleOutputView.printLadderResult();
        ConsoleOutputView.print(Formatters.usersFormatter.format(users));
        ConsoleOutputView.print(Formatters.ladderGameFormatter.format(ladderGame));
        ConsoleOutputView.print(Formatters.ladderResultsFormatter.format(ladderResults));

        while (true) {
            try {
                showResult(gameInfo, ladderGame);
            } catch (final NotFoundUserException e) {
                ConsoleOutputView.print(e.getMessage());
            }
        }
    }

    private void showResult(final GameInfo gameInfo,
                            final LadderGame ladderGame) {
        final String usernameOfWantResult = ConsoleInputView.readUsernameOfWantResult();
        if (gameInfo.isShowAll(usernameOfWantResult)) {
            ConsoleOutputView.printResult();
            showAll(ladderGame, gameInfo);

            System.exit(0);
        }

        final String winningResult = gameInfo.findWinningResult(usernameOfWantResult, ladderGame);

        ConsoleOutputView.printResult();
        ConsoleOutputView.print(winningResult);
    }

    private void showAll(final LadderGame ladderGame,
                         final GameInfo gameInfo) {
        gameInfo.userStream()
                .map(User::getUsername)
                .map(Username::getUsername)
                .forEach(username -> {
                    final String winningResult = gameInfo.findWinningResult(username, ladderGame);
                    ConsoleOutputView.printMatchingResult(username, winningResult);
                });
    }
}
