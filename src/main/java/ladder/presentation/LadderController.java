package ladder.presentation;

import ladder.domain.*;
import ladder.presentation.input.LadderHeightInputView;
import ladder.presentation.input.LadderResultInputView;
import ladder.presentation.input.UsersInputView;
import ladder.presentation.output.ResultOutputView;

public class LadderController {

    public void run() {

        Users users = Users.create(inputUsers());
        LadderResults ladderResults = LadderResults.create(inputLadderResults());

        Width width = Width.create(users.size() - 1);
        Height height = Height.create(inputLadderHeight());

        Ladder ladder = Ladder.create(width, height);
        outputResult(users, ladder, ladderResults);
    }

    private void outputResult(Users users, Ladder ladder, LadderResults ladderResults) {
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
