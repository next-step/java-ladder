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

        Ladder ladder = new Ladder(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderGameInformation, ladder);

        LadderResult ladderResult = new LadderResult(ladder.run());
        LadderGameResult ladderGameResult = ladderGame.getLadderGameResult(ladderResult);

        LadderGameView.printLadders(ladderGameInformation, ladderGameResult);
        LadderGameView.printLadderGameResult(ladderGameResult.getResults());
    }
}
