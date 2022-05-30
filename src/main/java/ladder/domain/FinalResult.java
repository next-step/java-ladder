package ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class FinalResult {
    private final static int INITIAL = 0;

    private final Map<String, String> finalResult;

    private FinalResult(Ladder ladder, LadderResult ladderResult, List<String> names) {
        List<String> results = ladderResult.findLadderResult(ladder);
        Map<String, String> temporary = new LinkedHashMap<>();
        IntStream.range(INITIAL, results.size()).forEachOrdered(index -> {
            temporary.put(names.get(index), results.get(index));
        });

        this.finalResult = new LinkedHashMap<>(temporary);
    }

    public static FinalResult of(Ladder ladder, LadderResult ladderResult, List<String> names) {
        return new FinalResult(ladder, ladderResult, names);
    }

    public Map<String, String> getFinalResult() {
        return finalResult;
    }
}
