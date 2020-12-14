package ladder.controller;

import ladder.domain.*;
import ladder.view.LadderGameView;

import java.util.Random;

public class LadderGameController {

    public void getLadderGameInformation() {
        LadderGameInformation ladderGameInformation = new LadderGameInformation(
                LadderGameView.enterParticipants(),
                LadderGameView.enterLadderGameResult()
        );
        LadderSize ladderSize = new LadderSize(ladderGameInformation.participantsCount(), LadderGameView.enterMaxLadderHeight());

        Ladder ladder = new Ladder(ladderSize, () -> new Random().nextBoolean());
        LadderGame ladderGame = new LadderGame(ladderGameInformation, ladder);

        LadderGameView.printLadders(ladderGameInformation, ladderGame.getResult());
    }
}
