package ladder.controller;

import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LineCount;
import ladder.domain.ladder.Lines;
import ladder.domain.ladder.LadderCreator;
import ladder.domain.player.LadderPlayers;
import ladder.ui.InputView;
import ladder.ui.ResultView;

public class LadderController {

    public static void main(String[] args) {
        LadderPlayers ladderPlayers = InputView.inputGamerNames();
        LadderHeight ladderHeight = InputView.inputLadderMaxHeight();

        LineCount requestLineCount = ladderPlayers.getRequestLineCount();
        LadderCreator ladderCreator = LadderCreator.create(requestLineCount, ladderHeight);
        Lines lines = ladderCreator.getLines();

        ResultView.printResult(ladderPlayers, lines);
    }
}
