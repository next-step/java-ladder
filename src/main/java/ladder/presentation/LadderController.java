package ladder.presentation;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.domain.Width;
import ladder.presentation.input.LadderHeightInputView;
import ladder.presentation.input.LadderResultInputView;
import ladder.presentation.input.UsersInputView;
import ladder.presentation.output.ResultOutputView;

public class LadderController {

    public void run() {

        Users users = Users.create(inputUsers());



        Width width = Width.create(users.size() - 1);
        Height height = Height.create(inputLadderHeight());
        Ladder ladder = Ladder.create(width, height);
        outputResult(users, ladder);
    }

    private void outputResult(Users users, Ladder ladder) {
        ResultOutputView outputView = new ResultOutputView();
        outputView.output(users, ladder);
    }

    private String inputUsers() {
        UsersInputView view = new UsersInputView();
        return view.input();
    }

    private String inputLadderResults() {
        LadderResultInputView view = new LadderResultInputView();
        return view.input();
    }

    private int inputLadderHeight() {
        LadderHeightInputView view = new LadderHeightInputView();
        return view.input();
    }
}
