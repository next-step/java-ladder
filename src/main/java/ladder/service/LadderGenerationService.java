package ladder.service;

import ladder.domain.MatchingItems;
import ladder.domain.Ladder;
import ladder.domain.Participants;

public class LadderGenerationService {

    public Participants registerParticipants(String participantNames) {
        return new Participants(participantNames);
    }

    public Ladder generateLadder(int participantsCount, int ladderHeight) {
        return new Ladder(participantsCount, ladderHeight);
    }

    public MatchingItems generateGameResults(String gameResultNames, int participantsCount) {
        return new MatchingItems(gameResultNames, participantsCount);
    }
}
