package ladder.controller;

import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LineCount;
import ladder.domain.ladder.Lines;
import ladder.domain.ladder.LinesCreator;
import ladder.domain.player.LadderPlayers;
import ladder.ui.InputView;
import ladder.ui.ResultView;

public class LadderController {

    public static void main(String[] args) {
        LadderPlayers ladderPlayers = InputView.inputGamerNames();
        LadderHeight ladderHeight = InputView.inputLadderMaxHeight();

        LineCount requestLineCount = ladderPlayers.getRequestLineCount();
        LinesCreator linesCreator = LinesCreator.create(requestLineCount, ladderHeight);
        Lines lines = linesCreator.getLines();

        ResultView.printResult(ladderPlayers, lines);
    }
}
