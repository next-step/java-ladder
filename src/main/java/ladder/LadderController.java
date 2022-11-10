package ladder;

import ladder.model.Ladder;
import ladder.model.LadderFactory;
import ladder.model.LadderHeight;
import ladder.model.UserList;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        UserList userList = UserList.parse(inputView.inputUserNames());
        Ladder ladder = LadderFactory.INSTANCE.generateLadder(userList.size(), new LadderHeight(inputView.inputLadderHeight()));

        resultView.printResult(userList, ladder);
    }
}
