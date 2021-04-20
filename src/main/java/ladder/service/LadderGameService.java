package ladder.service;

import ladder.domain.Ladder;
import ladder.domain.MatchingItems;
import ladder.domain.Participant;
import ladder.domain.Participants;
import ladder.controller.dto.LadderGameResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<LadderGameResult> executeGame(Participants participants, Ladder ladder, MatchingItems matchingItems) {
        List<LadderGameResult> gameResults = new ArrayList<>();
        int entranceNumber = Participants.MIN_ENTRANCE_NUMBER;
        for (Participant participant : participants.getParticipants()) {
            gameResults.add(new LadderGameResult(participant.getName(), matchingItems.getGameResult(ladder.getExitNumber(entranceNumber++))));
        }
        return Collections.unmodifiableList(gameResults);
    }
}