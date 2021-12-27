package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class PlayGame {
    private final Participants participants;
    private final Compensations compensations;

    private PlayGame(Participants participants, Compensations compensations) {
        this.participants = participants;
        this.compensations = compensations;
    }

    public static PlayGame of(Participants participants, Compensations compensations) {
        return new PlayGame(participants, compensations);
    }

    public Map<String, String> playGame(Participant participantWantResult, Ladder ladder) {
        if (participantWantResult.getParticipant().equals("all")) {
            return playAll(ladder);
        }
        return playOne(participantWantResult, ladder);
    }

    private Map<String, String> playAll(Ladder ladder) {
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < participants.getParticipantsSize(); i++) {
            int compensationIndex = ladder.move(i);
            result.put(participants.getParticipants().get(i).getParticipant(), compensations.getCompensationByIndex(compensationIndex));
        }
        return result;
    }

    private Map<String, String> playOne(Participant participantWantResult, Ladder ladder) {
        Map<String, String> result = new HashMap<>();
        int participantIndex = participantWantResult.getIndex();
        int compensationIndex = ladder.move(participantIndex);
        result.put(participantWantResult.getParticipant(), compensations.getCompensationByIndex(compensationIndex));
        return result;
    }
}
