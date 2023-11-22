package ladder.controller;

import ladder.controller.dto.LadderRequest;
import ladder.domain.*;
import ladder.factory.RowStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private final InputView inputView;
    private final ResultView resultView;
    private final RowStrategy rowStrategy;

    public LadderController(InputView inputView, ResultView resultView, RowStrategy rowStrategy) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.rowStrategy = rowStrategy;
    }

    public void run() {
        LadderRequest request = new LadderRequest(inputView.names(), inputView.results(), inputView.ladderHeight());

        Names names = request.names();
        Ladder ladder = new Ladder(request.ladderHeight(), names.size(), rowStrategy);
        Results results = request.results();
        LadderResult ladderResult = new LadderResult(names, ladder, results);

        resultView.printLadder(names, ladder, results);
        resultView.printResult(ladderResult, new Name(inputView.resultTarget()));
    }

}
