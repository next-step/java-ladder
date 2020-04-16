package ladder.ui;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private GameResult gameResult;

    public LadderController() {
        init();
    }

    private void init() {
        Users users = getUsers(InputView.askNumberOfUser());
        LadderGoals ladderGoals = getResult(InputView.askLadderGoals());
        Ladder ladder = new Ladder(InputView.askLadderHeight(), users);
        gameResult = new GameResult(users, ladder, ladderGoals);
    }

    public void showResult() {
        OutputView.printNames(gameResult.getUsers());
        OutputView.printLadder(gameResult.getLadder());
        OutputView.printGoals(gameResult.getLadderGoals());
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
