package ladder.controller;

import ladder.domain.*;
import ladder.view.LadderGameView;

public class LadderGameController {

    public void getLadderGameInformation() {
        LadderGameInformation ladderGameInformation = new LadderGameInformation(
                LadderGameView.enterParticipants(),
                LadderGameView.enterLadderGameResult()
        );
        LadderSize ladderSize = new LadderSize(ladderGameInformation.getParticipantsCount(), LadderGameView.enterMaxLadderHeight());
        Ladder ladder = new Ladder(ladderSize);
        LadderGame ladderGame = new LadderGame(ladder);
        LadderGameResult ladderGameResult = new LadderGameResult(ladderGameInformation, ladderGame.getLadderResult());

        LadderGameView.printLadders(ladder, ladderGameResult);
    }
}
