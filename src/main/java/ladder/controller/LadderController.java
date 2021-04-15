package ladder.controller;

import ladder.domain.Line;
import ladder.domain.LineResults;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    private final InputView inputView;

    public LadderController(InputView inputView) {
        this.inputView = inputView;
    }

    public ResultView startLadderGame() {
        LineResults lineResults = new LineResults();
        for (int i = 0; i < inputView.getLadderHeight(); i++) {
            Line ladderLine = new Line(inputView.playersCount());
            lineResults.add(ladderLine);
        }
        return new ResultView(inputView.getPlayers(), lineResults);
    }
}
