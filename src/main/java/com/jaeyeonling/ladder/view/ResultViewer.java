package com.jaeyeonling.ladder.view;

import com.jaeyeonling.ladder.domain.ladder.LadderGame;
import com.jaeyeonling.ladder.domain.ladder.LadderResults;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Username;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.view.console.ConsoleInputView;
import com.jaeyeonling.ladder.view.console.ConsoleOutputView;
import com.jaeyeonling.ladder.view.format.Formatters;

public class ResultViewer {

    private final Users users;
    private final LadderGame ladderGame;
    private final LadderResults ladderResults;

    public ResultViewer(final Users users,
                        final LadderGame ladderGame,
                        final LadderResults ladderResults) {
        this.users = users;
        this.ladderGame = ladderGame;
        this.ladderResults = ladderResults;
    }

    public void view() {
        ConsoleOutputView.printLadderResult();
        ConsoleOutputView.print(Formatters.usersFormatter.format(users));
        ConsoleOutputView.print(Formatters.ladderGameFormatter.format(ladderGame));
        ConsoleOutputView.print(Formatters.ladderResultsFormatter.format(ladderResults));

        while (true) {
            showResult();
        }
    }

    private void showResult() {
        final String usernameOfWantResult = ConsoleInputView.readUsernameOfWantResult();
        if (isShowAll(usernameOfWantResult)) {
            showAllResult();
        }

        showSingleResult(usernameOfWantResult);
    }

    private boolean isShowAll(final String usernameOfWantResult) {
        return "all".equalsIgnoreCase(usernameOfWantResult);
    }

    private void showSingleResult(final String usernameOfWantResult) {
        final int indexOfLadder = users.findIndexByUsername(usernameOfWantResult);
        final int indexOfResult = ladderGame.ride(indexOfLadder);

        final String winningResult = ladderResults.findByIndex(indexOfResult);

        ConsoleOutputView.printResult();
        ConsoleOutputView.print(winningResult);
    }

    private void showAllResult() {
        ConsoleOutputView.printResult();

        users.stream()
                .map(User::getUsername)
                .map(Username::getUsername)
                .forEach(this::showMatchingResultByUsername);

        System.exit(0);
    }

    private void showMatchingResultByUsername(final String username) {
        final int indexOfLadder = users.findIndexByUsername(username);
        final int indexOfResult = ladderGame.ride(indexOfLadder);

        final String winningResult = ladderResults.findByIndex(indexOfResult);

        ConsoleOutputView.printMatchingResult(username, winningResult);
    }
}
