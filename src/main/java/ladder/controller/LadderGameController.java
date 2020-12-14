package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.LadderHeight;
import ladder.domain.LadderResult;
import ladder.domain.Participants;
import ladder.view.LadderGameView;

public class LadderGameController {

    public void getLadderGameInformation() {
        Participants participants = new Participants(LadderGameView.enterParticipants());

        LadderResult ladderResult = new LadderResult(LadderGameView.enterLadderGameResult());

        LadderHeight ladderHeight = new LadderHeight(LadderGameView.enterMaxLadderHeight());

        LadderGame ladderGame = new LadderGame(participants, ladderHeight);

        LadderGameView.printLadders(ladderGame.getLadderGameResult());
    }
}
