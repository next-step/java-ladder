package ladder.controller;

import ladder.domain.*;
import ladder.view.LadderGameView;

public class LadderGameController {

    public void getLadderGameInformation() {
        LadderGameInformation ladderGameInformation = new LadderGameInformation(
                LadderGameView.enterParticipants(),
                LadderGameView.enterLadderGameResult()
        );
        LadderSize ladderSize = new LadderSize(ladderGameInformation.participantsCount(), LadderGameView.enterMaxLadderHeight());

        LadderGame ladderGame = new LadderGame(ladderGameInformation, ladderSize);
        LadderGameView.printLadders(ladderGameInformation, ladderGame.getResult());
    }
}
