package ladder.controller;

import ladder.view.LadderGameView;

public class LadderGameController {

    public void getLadderInformation() {
        String person = LadderGameView.enterParticipants();
        int height = LadderGameView.enterMaxLadderHeight();
    }
}
