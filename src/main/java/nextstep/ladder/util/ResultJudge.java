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

        int currIndex;
        for (int i = 0; i < participantsSize; i++) {
            currIndex = i;
            List<Line> lines = ladder.getLines();
            for (Line line : lines) {
                List<Boolean> points = line.getPoints();
                //왼쪽검사
                if (currIndex > 0) {
                    if (points.get(currIndex - 1)) {
                        currIndex--;
                        continue;
                    }
                }
                //오른쪽검사
                if (currIndex < line.size()) {
                    if (points.get(currIndex)) {
                        currIndex++;
                    }
                }
            }
            result.put(participants.get(i).getValue(), executionResults.get(currIndex));
        }

        return result;
    }
}
