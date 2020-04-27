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
        Users users = InputView.askNumberOfUser();
        LadderGoals ladderGoals = InputView.askLadderGoals();
        Ladder ladder = new Ladder(InputView.askLadderHeight(), users);
        gameResult = new GameResult(users, new LadderGame(ladder, ladderGoals));
    }

    public void showResult() {
        OutputView.printNames(gameResult.getUsers());
        OutputView.printLadder(gameResult.getLadder());
        OutputView.printGoals(gameResult.getLadderGoals());
        OutputView.printGameResult(gameResult);
    }
}
