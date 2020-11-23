package nextstep.ladder.util;

import nextstep.ladder.domain.ExecutionsResults;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;

import java.util.HashMap;
import java.util.Map;

public class ResultJudge {
    public static Map<String, String> of(Ladder ladder, Participants participants, ExecutionsResults executionResults) {
        Map<String, String> result = new HashMap<>();
        int participantsSize = participants.getNumberOfParticipants().getValue();

        for (int i = 0; i < participantsSize; i++) {
            result.put(participants.get(i).getValue(), executionResults.get(ladder.getResult(i)));
        }

        return result;
    }
}
