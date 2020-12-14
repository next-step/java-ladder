package ladder.controller;

import ladder.domain.*;
import ladder.dto.LadderGameResultDto;
import ladder.view.LadderGameView;

import java.util.Random;

public class LadderGameController {

    public void getLadderGameInformation() {
        Participants participants = new Participants(LadderGameView.enterParticipants());
        LadderResult ladderResult = new LadderResult(LadderGameView.enterLadderGameResult());
        LadderHeight ladderHeight = new LadderHeight(LadderGameView.enterMaxLadderHeight());

        Ladder ladder = new Ladder(participants.size(), ladderHeight, () -> new Random().nextBoolean());

        LadderGame ladderGame = new LadderGame(participants, ladderResult);

        LadderGameResult result = new LadderGameResult(ladder, ladderResult);

        LadderGameResultDto ladderGameResultDto = new LadderGameResultDto(result, participants.getValue());
        LadderGameView.printLadders(ladderGameResultDto);
    }
}
