package ladder.ui;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private Users users;
    private LadderGoals ladderGoals;
    private Ladder ladder;

    public LadderController() {
        init();
    }

    private void init() {
        users = getUsers(InputView.askNumberOfUser());
        ladderGoals = getResult(InputView.askLadderGoals());
        ladder = new Ladder(InputView.askLadderHeight(), users);
    }

    public void showResult() {
        OutputView.printNames(users);
        OutputView.printLadder(ladder);
        OutputView.printResult(ladderGoals);
    }

    private Users getUsers(String user) {
        UserGenerator userGenerator = new UserGenerator(user);
        return new Users(userGenerator.generateUsers());
    }

    private LadderGoals getResult(String result) {
        GoalsGenerator resultGenerator = new GoalsGenerator(result);
        return resultGenerator.generate();
    }
}
