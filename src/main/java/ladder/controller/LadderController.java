package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Results;
import ladder.domain.Users;
import ladder.service.LadderResultService;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private static LadderController ladderController;
    private final LadderResultService ladderResultService;

    private LadderController(LadderResultService ladderResultService)
    {
        this.ladderResultService = ladderResultService;
    }

    public static LadderController getInstance() {
        if (ladderController == null) {
            ladderController = new LadderController(LadderResultService.getInstance());
        }

        return ladderController;
    }

    public void run() {
        Users users = Users.from(InputView.getNames());

        Results results = Results.of(InputView.getResult(), users.getUserCount());
        Ladder ladder = Ladder.of(users.getUserCount(), InputView.getHeight());

        OutputView.printLadder(users.getUserList(), ladder.getLines(), results.getResults());

        boolean isEnd = false;
        while (!isEnd) {
            isEnd = OutputView
                .printLadderResult(ladderResultService.getLadderResult(InputView.getTargetPlayer(), users.getUserList()
                    , ladder, results.getResults()));
        }
    }
}
