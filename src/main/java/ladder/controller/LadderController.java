package ladder.controller;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderCreator;
import ladder.domain.player.LadderPlayers;
import ladder.ui.InputView;
import ladder.ui.ResultView;

public class LadderController {

    public static void main(String[] args) {
        LadderPlayers ladderPlayers = InputView.inputGamerNames();
        int height = InputView.inputLadderMaxHeight();

        LadderCreator ladderCreator = LadderCreator.create(ladderPlayers, height);
    }
}
