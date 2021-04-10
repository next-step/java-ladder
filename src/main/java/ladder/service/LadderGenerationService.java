package ladder.service;

import ladder.domain.LadderGame;
import ladder.domain.Participants;

public class LadderGenerationService {

    public LadderGame generateLadder(String participantNames, int ladderHeight) {
        return new LadderGame(new Participants(participantNames), ladderHeight);
    }
}
