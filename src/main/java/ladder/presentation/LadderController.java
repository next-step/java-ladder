package ladder.presentation;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.domain.Width;

public class LadderController {

    public void run() {
        Users users = Users.create(inputUsers());
        Width width = Width.create(users.size());
        Height height = Height.create(inputLadderHeight());
        Ladder ladder = Ladder.create(width, height);
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
