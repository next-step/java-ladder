package ladder.controller;

import ladder.controller.dto.LadderRequest;
import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.domain.Names;
import ladder.domain.Results;
import ladder.factory.ColFactory;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private final InputView inputView;
    private final ResultView resultView;
    private final ColFactory colFactory;

    public LadderController(InputView inputView, ResultView resultView, ColFactory colFactory) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.colFactory = colFactory;
    }

    public void run() {
        LadderRequest request = new LadderRequest(inputView.names(), inputView.results(), inputView.ladderHeight());

        Names names = request.names();
        Ladder ladder = new Ladder(request.ladderHeight(), names.size(), colFactory);
        Results results = request.results();

        resultView.printResult(names, ladder, results);

        Name resultTarget = new Name(inputView.resultTarget());
    }

}
