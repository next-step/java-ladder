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
        HashMap<String, String> result = new HashMap<>();
        return playOne(participantWantResult, ladder, result);
    }

    private Map<String, String> playAll(Ladder ladder) {
        HashMap<String, String> result = new HashMap<>();
        for (int i = 0; i < participants.getParticipantsSize(); i++) {
            playOne(participants.getParticipants().get(i), ladder, result);
        }
        return result;
    }

    private Map<String, String> playOne(Participant participantWantResult, Ladder ladder, HashMap<String, String> result) {
        int index = participants.getParticipantIndex(participantWantResult.getParticipant());
        index = ladder.play(index);
        result.put(participantWantResult.getParticipant(), compensations.getCompensationByIndex(index));
        return result;
    }
}
