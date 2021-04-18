package ladder.service;

import ladder.domain.Ladder;
import ladder.domain.MatchingItems;
import ladder.domain.Participant;
import ladder.domain.Participants;
import ladder.service.dto.LadderGameResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderGameService {

    public List<LadderGameResult> executeGame(Participants participants, Ladder ladder, MatchingItems matchingItems) {
        List<LadderGameResult> gameResults = new ArrayList<>();
        int entranceNumber = Participants.MIN_ENTRANCE_NUMBER;
        for (Participant participant : participants.getParticipants()) {
            gameResults.add(new LadderGameResult(participant.getName(), matchingItems.getGameResult(ladder.getExitNumber(entranceNumber++))));
        }
        return Collections.unmodifiableList(gameResults);
    }
}