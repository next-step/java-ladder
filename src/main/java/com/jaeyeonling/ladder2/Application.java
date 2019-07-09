package com.jaeyeonling.ladder2;

import com.jaeyeonling.ladder2.domain.ladder.HeightOfLadder;
import com.jaeyeonling.ladder2.domain.ladder.LadderGame;
import com.jaeyeonling.ladder2.domain.ladder.LadderGameResult;
import com.jaeyeonling.ladder2.domain.line.RandomDirectionGenerateStrategy;
import com.jaeyeonling.ladder2.domain.reword.LadderRewords;
import com.jaeyeonling.ladder2.domain.user.Username;
import com.jaeyeonling.ladder2.domain.user.Users;
import com.jaeyeonling.ladder2.view.console.ConsoleInputView;
import com.jaeyeonling.ladder2.view.console.ConsoleOutputView;

import static com.jaeyeonling.ladder2.view.console.ConsoleOutputView.printSingleResult;

public class Application {

    public static void main(final String... args) {
        final Users users = Users.ofSeparator(ConsoleInputView.readUsers());
        final LadderRewords ladderRewords = LadderRewords.ofSeparator(ConsoleInputView.readLadderRewords());
        final HeightOfLadder heightOfLadder = HeightOfLadder.valueOf(ConsoleInputView.readLadderHeight());

        final LadderGame ladderGame = LadderGame.builder(users, ladderRewords)
                .heightOfLadder(heightOfLadder)
                .directionGenerateStrategy(new RandomDirectionGenerateStrategy())
                .build();
        ConsoleOutputView.printLadderReword(ladderGame);

        final LadderGameResult ladderGameResult = ladderGame.play();

        while (true) {
            final String usernameOfWantReword = ConsoleInputView.readUsernameOfWantReword();
            if (ladderGameResult.isShowAll(usernameOfWantReword)) {
                ConsoleOutputView.printGameResult(ladderGameResult);
                break;
            }

            final String visualized = ladderGameResult.visualize(Username.valueOf(usernameOfWantReword));
            printSingleResult(visualized);
        }
    }
}
