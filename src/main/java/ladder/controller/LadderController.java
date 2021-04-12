package ladder.controller;

import ladder.domain.Line;
import ladder.domain.LineResult;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LadderController {
    private final InputView inputView;

    public LadderController(InputView inputView) {
        this.inputView = inputView;
    }

    public ResultView startLadderGame() {
        List<LineResult> lineResults = new ArrayList<>();

        for (int i = 0; i < inputView.getLadderHeight(); i++) {
            Line ladderLine = Line.of(inputView.getPlayers());
            lineResults.add(ladderLine.makeLine());
        }
        return new ResultView(inputView.getPlayers(), lineResults);
    }
}
