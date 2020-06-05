package ladder.step4.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGameExecutor {

    private final Ladder ladder;

    private LadderGameExecutor (Ladder ladder) {
        this.ladder = ladder;
    }

    public static Map<Participant, LadderResult> execute (
        Participants participants,
        LadderResults ladderResults,
        Ladder ladder
    ) {
        return new LadderGameExecutor(ladder).execute(participants, ladderResults);
    }

    private Map<Participant, LadderResult> execute (
        Participants participants,
        LadderResults ladderResults
    ) {
        Map<Participant, LadderResult> resultMap = new HashMap<>();
        int width = participants.size();
        for (int index = 0; index < width; index++) {
            resultMap.put(
                participants.get(index),
                ladderResults.get(getResultIndex(index))
            );
        }
        return resultMap;
    }

    private int getResultIndex (int index) {
        return ladder.stream()
                     .reduce(index,
                         (x, ladderLine) -> ladderLine.move(x),
                         (x, ladderLine) -> x);
    }
}
