package ladder.step3.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

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
        int width = participants.size() - 1;
        for (int index = 0; index <= width; index++) {
            resultMap.put(
                participants.get(index),
                ladderResults.get(getResultIndex(index, width))
            );
        }
        return resultMap;
    }

    private int getResultIndex (int index, int width) {
        BiFunction<Integer, LadderLine, Integer> getNextIndex = (x, ladderLine) -> {
             if (x > 0 && ladderLine.get(x - 1)) return x - 1;
             if (x < width && ladderLine.get(x)) return x + 1;
             return x;
        };
        return ladder.stream()
                     .reduce(index, getNextIndex, (x, ladderLine) -> x);
    }
}
