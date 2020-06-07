package ladder.controller;

import ladder.domain.player.LadderPlayers;
import ladder.ui.InputView;

public class LadderController {

    public static void main(String[] args) {
        LadderPlayers ladderPlayers = InputView.inputGamerNames();
        int height = InputView.inputLadderMaxHeight();

    }
}
