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
        OutputView.printLadders(users, ladder, ladderGoals);

        ladderResult = new LadderResult(ladder.play(users, ladderGoals));
        OutputView.printGameResult(ladderResult);
    }

}
