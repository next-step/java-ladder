package ladder.ui;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private LadderResult ladderResult;

    public LadderController() {
        init();
    }

    private void init() {
        Users users = InputView.askNumberOfUser();
        LadderGoals ladderGoals = InputView.askLadderGoals();
        Ladder ladder = new Ladder(InputView.askLadderHeight(), new DirectionGenerator(users.size()));

        OutputView.printNames(users);
        OutputView.printLadder(ladder);
        OutputView.printGoals(ladderGoals);
        ladderResult = new LadderResult(ladder.play(users, ladderGoals));
    }

    public void showResult() {
        OutputView.printGameResult(ladderResult);
    }
}
