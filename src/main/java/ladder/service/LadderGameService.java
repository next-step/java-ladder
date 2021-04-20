package ladder.service;

import ladder.domain.Ladder;
import ladder.domain.MatchingItems;
import ladder.domain.Participant;
import ladder.domain.Participants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderGameService {

    public Participants registerParticipants(String participantNames) {
        return new Participants(participantNames);
    }

    public Ladder generateLadder(int participantsCount, int ladderHeight) {
        return new Ladder(participantsCount, ladderHeight);
    }

    public MatchingItems generateMatchingItems(String gameResultNames, int participantsCount) {
        return new MatchingItems(gameResultNames, participantsCount);
    }

    public Map<Participant, String> executeGame(Participants participants, Ladder ladder, MatchingItems matchingItems) {
        Map<Participant, String> gameResults = new HashMap<>();
        int entranceNumber = Participants.MIN_ENTRANCE_NUMBER;
        for (Participant participant : participants.getParticipants()) {
            gameResults.put(participant, matchingItems.getGameResult(ladder.getExitNumber(entranceNumber++)));
        }
        return Collections.unmodifiableMap(gameResults);
    }
}