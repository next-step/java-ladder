package ladder.controller;

import ladder.domain.Line;
import ladder.domain.LineResults;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public void startLadderGame() {
        try {
            InputView inputView = new InputView();
            inputView.inputPlayer();
            inputView.inputLadderHeight();

            LineResults lineResults = new LineResults();
            for (int i = 0; i < inputView.getLadderHeight(); i++) {
                Line ladderLine = new Line(inputView.playersCount());
                lineResults.add(ladderLine);
            }
            new ResultView(inputView.getPlayers(), lineResults).showLadderDrawResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
