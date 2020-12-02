package ladder.controller;

import ladder.domain.LadderGame;
import ladder.view.InputView;

public class PlayLadderGame {

    public void playGame() {
        String names = InputView.inputNames();
        int ladderHeight = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(names, ladderHeight);
        ladderGame.printLadder();
    }
}
