package laddergame.domain;

import java.util.List;

public class LadderGame {

    public LadderGameResult run(List<ParticipantName> participantNames, LadderHeight height) {
        return LadderGameResult.of(participantNames, height);
    }

}
