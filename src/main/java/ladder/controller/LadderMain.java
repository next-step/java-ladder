package ladder.controller;

import ladder.model.Ladder;
import ladder.model.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] arg) {
        String ladderUserNames = InputView.inputLadderUser();
        String ladderHeight = InputView.inputLadderHeight();

        Users users = new Users(ladderUserNames);
        Ladder ladder = new Ladder(users.userCount(), ladderHeight);

        OutputView.printLadderUser(users);
        OutputView.printLadder(ladder);
    }

}