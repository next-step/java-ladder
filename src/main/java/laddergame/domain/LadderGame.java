package laddergame.domain;

import laddergame.dto.LadderGameResult;

import java.util.List;

public class LadderGame {

    public LadderGameResult run(List<ParticipantName> participantNames, int height) {
        Ladder ladder = Ladder.of(participantNames.size(), height);
        return new LadderGameResult(participantNames, ladder);
    }

}
