package ladder.controller;

import ladder.Model.Ladder;
import ladder.Model.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] arg) {
        String ladderUserNames = InputView.inputLadderUser();
        int ladderHeight = InputView.inputLadderHeight();

        Users users = new Users(ladderUserNames);
        Ladder ladder = new Ladder(users.userCount(), ladderHeight);

        OutputView.printLadderUser(users);
        OutputView.printLadder(ladder);
    }

}