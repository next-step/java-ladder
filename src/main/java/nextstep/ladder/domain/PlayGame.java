package nextstep.ladder.domain;

import java.util.HashMap;

public class PlayGame {
    public static HashMap<String, String> playGame(Participant participantWantResult, Participants participants, Compensations compensations, Ladder ladder) {
        HashMap<String, String> result = new HashMap<String, String>();
        if (participantWantResult.equals(Participant.of("all"))) {
            return playAll(participants, compensations, ladder, result);
        }
        return playOne(participantWantResult, participants, compensations, ladder, result);
    }

    public static HashMap<String, String> playAll(Participants participants, Compensations compensations, Ladder ladder, HashMap<String, String> result) {
        for (int i = 0; i < participants.getParticipantsSize(); i++) {
            playOne(participants.getParticipants().get(i), participants, compensations, ladder, result);
        }
        return result;
    }


    public static HashMap<String, String> playOne(Participant participantWantResult, Participants participants, Compensations compensations, Ladder ladder, HashMap<String, String> result) {
        int index = -1;
        for (int i = 0; i < participants.getParticipantsSize(); i++) {
            if (participantWantResult.equals(participants.getParticipants().get(i))) {
                index = i;
            }
        }
        checkParticipant(index);
        for (Line line : ladder.getLines()) {
            if (line.getPoints().get(index) == Point.of("right")) {
                index += 1;
            } else if (line.getPoints().get(index) == Point.of("left")) {
                index -= 1;
            }
        }
        result.put(participantWantResult.getParticipant(), compensations.getCompensations().get(index));
        return result;
    }

    public static void checkParticipant(int index) {
        if (index == -1) {
            throw new IllegalArgumentException("해당 참가자가 없습니다.");
        }
    }
}
