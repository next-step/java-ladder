package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;

public class PlayLadderGame {
    public void playGame() {
        String names = InputView.inputNames();
        String winnings = InputView.inputLadderResult();
        int ladderHeight = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(names, ladderHeight, winnings);
        LadderPrint ladderPrint = new LadderPrint(ladderGame);

        ladderPrint.resultPrint();
    }
}
