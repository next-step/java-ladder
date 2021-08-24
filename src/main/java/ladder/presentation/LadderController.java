package ladder.presentation;

import ladder.domain.Ladder;
import ladder.domain.Users;

public class LadderController {

    public void run() {
        Users users = Users.create(inputUsers());
        Ladder ladder = Ladder.createWithHeight(inputLadderHeight());
    }

    private String inputUsers() {
        UsersInputView view = new UsersInputView();
        return view.input();
    }

    private int inputLadderHeight() {
        LadderHeightInputView view = new LadderHeightInputView();
        return view.input();
    }
}
