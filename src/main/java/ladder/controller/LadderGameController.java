package ladder.controller;

import ladder.domain.*;
import ladder.dto.LadderGameResultDto;
import ladder.view.LadderGameView;

import java.util.Random;

public class LadderGameController {

    public void getLadderGameInformation() {
        Participants participants = new Participants(LadderGameView.enterParticipants());
        LadderResult ladderResult = new LadderResult(LadderGameView.enterLadderGameResult());
        LadderSize ladderSize = new LadderSize(participants.size(), LadderGameView.enterMaxLadderHeight());

        Ladder ladder = new Ladder(ladderSize, () -> new Random().nextBoolean());

        LadderGameResult result = new LadderGameResult(ladder, ladderResult);

        LadderGameResultDto ladderGameResultDto = new LadderGameResultDto(result, participants.getValue());
        LadderGameView.printLadders(ladderGameResultDto);
    }
}
