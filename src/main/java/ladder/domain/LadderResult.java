package ladder.domain;

import java.util.*;

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
        List<Integer> resultIndexes = ladder.resultIndexes(ladderResult.size());
        List<String> results = new ArrayList<>();

        resultIndexes.stream().forEachOrdered(index -> results.add(ladderResult.get(index)));

        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(getLadderResult(), that.getLadderResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLadderResult());
    }
}


