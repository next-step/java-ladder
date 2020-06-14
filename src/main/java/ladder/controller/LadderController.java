package ladder.controller;

import ladder.domain.ladder.ladderInfo.LadderHeight;
import ladder.domain.ladder.ladderInfo.LineCount;
import ladder.domain.player.LadderPlayers;
import ladder.ui.InputView;

public class LadderController {

    public static void main(String[] args) {
        LadderPlayers ladderPlayers = InputView.inputGamerNames();
        LadderHeight ladderHeight = InputView.inputLadderMaxHeight();
        LineCount requestLineCount = ladderPlayers.getRequestLineCount();


    }
}
