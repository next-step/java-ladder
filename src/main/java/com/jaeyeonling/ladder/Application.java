package com.jaeyeonling.ladder;

import com.jaeyeonling.ladder.domain.GameResult;
import com.jaeyeonling.ladder.domain.ladder.LadderGame;
import com.jaeyeonling.ladder.domain.ladder.LadderReword;
import com.jaeyeonling.ladder.domain.ladder.LadderRewords;
import com.jaeyeonling.ladder.domain.line.HeightOfLadder;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.view.console.ConsoleInputView;
import com.jaeyeonling.ladder.view.console.ConsoleOutputView;

import java.util.Objects;

public class Application {

    public static void main(final String... args) {
        final Users users = Users.ofSeparator(ConsoleInputView.readUsers());
        final LadderRewords ladderRewords = LadderRewords.ofSeparator(ConsoleInputView.readLadderRewords());
        final HeightOfLadder heightOfLadder = HeightOfLadder.valueOf(ConsoleInputView.readLadderHeight());

        final LadderGame ladderGame = LadderGame.builder(users, ladderRewords)
                .heightOfLadder(heightOfLadder)
                .build();

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

    private static void showSingle(final GameResult gameResult,
                                   final String usernameOfWantReword) {
        final LadderReword matchingReword = gameResult.findMatchingReword(usernameOfWantReword);
        if (Objects.isNull(matchingReword)) {
            ConsoleOutputView.printUserNotFound(usernameOfWantReword);
            return;
        }

        ConsoleOutputView.printSingleResult(matchingReword);
    }
}
