package ladder.service;

import ladder.domain.GameResults;
import ladder.domain.Ladder;
import ladder.domain.Participants;

public class LadderGenerationService {

    public Participants registerParticipants(String participantNames) {
        return new Participants(participantNames);
    }

    public Ladder generateLadder(int participantsCount, int ladderHeight) {
        return new Ladder(participantsCount, ladderHeight);
    }

    public GameResults generateGameResults(String gameResultNames, int participantsCount) {
        return new GameResults(gameResultNames, participantsCount);
    }
}
