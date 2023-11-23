package ladder.controller;

import ladder.controller.dto.LadderRequest;
import ladder.domain.*;
import ladder.factory.RandomRowStrategy;
import ladder.factory.RowStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private final InputView inputView;
    private final ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        LadderRequest request = new LadderRequest(inputView.names(), inputView.results(), inputView.ladderHeight());

        Names names = request.names();
        RowStrategy rowStrategy = new RandomRowStrategy(request.ladderHeight(), names.size());
        Ladder ladder = new Ladder(rowStrategy);
        Results results = request.results();
        LadderResult ladderResult = new LadderResult(names, ladder, results);

        resultView.printLadder(names, ladder, results);
        resultView.printResult(ladderResult, new Name(inputView.resultTarget()));
    }

}
