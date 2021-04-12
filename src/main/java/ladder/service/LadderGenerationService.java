package ladder.service;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Participants;

public class LadderGenerationService {

    public LadderGame generateLadderGame(String participantNames, int ladderHeight) {
        return new LadderGame(new Participants(participantNames), ladderHeight);
    }

    public Participants registerParticipants(String participantNames) {
        return new Participants(participantNames);
    }

    public Ladder generateLadder(int participantsCount, int ladderHeight) {
        return new Ladder(participantsCount, ladderHeight);
    }
}
