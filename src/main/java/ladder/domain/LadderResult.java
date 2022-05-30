package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    private final List<String> ladderResult;

    private LadderResult(List<String> ladderResult) {
        this.ladderResult = new ArrayList<>(ladderResult);
    }

    public static LadderResult of(List<String> ladderResult) {
        return new LadderResult(ladderResult);
    }

    public List<String> getLadderResult() {
        return ladderResult;
    }

    public List<String> findLadderResult(Ladder ladder) {
        List<Integer> resultIndexes = ladder.resultIndexes();
        List<String> results = new ArrayList<>();

        resultIndexes.stream().forEachOrdered(index -> results.add(ladderResult.get(index)));

        return results;
    }
}
