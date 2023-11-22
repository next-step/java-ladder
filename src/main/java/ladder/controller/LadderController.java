package ladder.controller;

import ladder.controller.dto.LadderRequest;
import ladder.domain.*;
import ladder.factory.RowFactory;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private final InputView inputView;
    private final ResultView resultView;
    private final RowFactory rowFactory;

    public LadderController(InputView inputView, ResultView resultView, RowFactory rowFactory) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.rowFactory = rowFactory;
    }

    public void run() {
        LadderRequest request = new LadderRequest(inputView.names(), inputView.results(), inputView.ladderHeight());

        Names names = request.names();
        Ladder ladder = new Ladder(request.ladderHeight(), names.size(), rowFactory);
        Results results = request.results();
        LadderResult ladderResult = new LadderResult(names, ladder, results);

        resultView.printLadder(names, ladder, results);
        resultView.printResult(ladderResult, new Name(inputView.resultTarget()));
    }

}
