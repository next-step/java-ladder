package ladder.controller;

import ladder.domain.LadderGame;
import ladder.view.LadderGameView;

public class LadderGameController {

    public void getLadderGameInformation() {
        String names = LadderGameView.enterParticipants();
        int height = LadderGameView.enterMaxLadderHeight();

        LadderGame ladderGame = new LadderGame(names, height);


    }
}
