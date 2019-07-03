package com.jaeyeonling.ladder;

import com.jaeyeonling.ladder.domain.GameInfo;
import com.jaeyeonling.ladder.domain.ladder.*;
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

        final LadderGame ladderGame = ladderGameGenerator.generate(gameInfo, heightOfLadder);

        ConsoleOutputView.printLadderResult();
        ConsoleOutputView.print(Formatters.usersFormatter.format(users));
        ConsoleOutputView.print(Formatters.ladderGameFormatter.format(ladderGame));
        ConsoleOutputView.print(Formatters.ladderResultsFormatter.format(ladderResults));

        while (true) {
            try {
                showResult(ladderGame);
            } catch (final NotFoundUserException e) {
                ConsoleOutputView.print(e.getMessage());
            }
        }
    }

    private void showResult(final LadderGame ladderGame) {
        final String usernameOfWantResult = ConsoleInputView.readUsernameOfWantResult();
        if (ladderGame.isShowAll(usernameOfWantResult)) {
            ConsoleOutputView.printResult();
            showAll(ladderGame);

            System.exit(0);
        }

        final LadderResult winningResult = ladderGame.findWinningResult(usernameOfWantResult);

        ConsoleOutputView.printResult();
        ConsoleOutputView.print(Formatters.ladderResultFormatter.format(winningResult));
    }

    private void showAll(final LadderGame ladderGame) {
        ladderGame.userStream()
                .map(User::getUsername)
                .map(Username::getUsername)
                .forEach(username -> {
                    final LadderResult winningResult = ladderGame.findWinningResult(username);
                    final String formattedWinningResult = Formatters.ladderResultFormatter.format(winningResult);

                    ConsoleOutputView.printMatchingResult(username, formattedWinningResult);
                });
    }
}
