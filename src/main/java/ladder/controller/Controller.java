package ladder.controller;

import ladder.Ladder;
import ladder.view.MaxLadderHeightInputView;
import ladder.view.ResultView;
import ladder.view.UserNameInputView;

public class Controller {
    public void run() {
        UserNameInputView userNameInputView = new UserNameInputView();
        MaxLadderHeightInputView maxLadderHeightInputView = new MaxLadderHeightInputView();

        Ladder ladder = new Ladder(userNameInputView.userCount(), maxLadderHeightInputView.height());

        ResultView resultView = new ResultView(userNameInputView.toString(), ladder);
        resultView.showResult();
    }
}
