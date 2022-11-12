package ladder;

import ladder.model.Ladder;
import ladder.model.LadderFactory;
import ladder.model.LadderHeight;
import ladder.model.Users;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Users users = Users.from(inputView.inputUserNames());
        Ladder ladder = LadderFactory.INSTANCE.generateLadder(users.size(), new LadderHeight(inputView.inputLadderHeight()));

        resultView.printResult(users, ladder);
    }
}
