package ladder.ui;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private Users users;
    private LadderResult ladderResult;
    private Ladder ladder;

    public LadderController() {
        init();
    }

    private void init() {
        users = getUsers(InputView.askNumberOfUser());
        ladderResult = getResult(InputView.askLadderResult());
        ladder = new Ladder(InputView.askLadderHeight(), users);
    }

    public void showResult() {
        OutputView.printNames(users);
        OutputView.printLadder(ladder);
        OutputView.printResult(ladderResult);
    }

    private Users getUsers(String user) {
        UserGenerator userGenerator = new UserGenerator(user);
        return new Users(userGenerator.generateUsers());
    }

    private LadderResult getResult(String result) {
        ResultGenerator resultGenerator = new ResultGenerator(result);
        return resultGenerator.generate();
    }
}
