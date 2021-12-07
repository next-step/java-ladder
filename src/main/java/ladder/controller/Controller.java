package ladder.controller;

import ladder.domain.Ladder;
import ladder.view.input.GameResultSettingInputView;
import ladder.view.input.MaxLadderHeightInputView;
import ladder.view.input.UserNameAndResult;
import ladder.view.result.ResultView;
import ladder.view.input.UserNameInputView;

public class Controller {
    public void run() {
        UserNameInputView userNameInputView = new UserNameInputView();
        GameResultSettingInputView gameResultSettingInputView = new GameResultSettingInputView(userNameInputView.userCount());
        MaxLadderHeightInputView maxLadderHeightInputView = new MaxLadderHeightInputView();

        Ladder ladder = new Ladder(userNameInputView.userCount(), maxLadderHeightInputView.height());

        UserNameAndResult userNameAndResult = new UserNameAndResult(userNameInputView, gameResultSettingInputView);

        ResultView resultView = new ResultView(userNameAndResult, ladder);
        resultView.showLadderGame();
        resultView.showResult();
    }
}
