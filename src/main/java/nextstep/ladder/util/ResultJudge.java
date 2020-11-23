package nextstep.ladder.util;

import nextstep.ladder.domain.ExecutionsResults;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultJudge {
    public static Map<String, String> of(Ladder ladder, Participants participants, ExecutionsResults executionResults) {
        Map<String, String> result = new HashMap<>();
        int participantsSize = participants.getNumberOfParticipants().getValue();

        final int[] currIndex = {0};
        for (int i = 0; i < participantsSize; i++) {
            currIndex[0] = i;
            List<Line> lines = ladder.getLines();
            lines.forEach(line -> currIndex[0] = line.moveIndex(currIndex[0]));
            result.put(participants.get(i).getValue(), executionResults.get(currIndex[0]));
        }

        return result;
    }
}
