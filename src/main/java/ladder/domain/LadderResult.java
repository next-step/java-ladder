package ladder.domain;

import java.util.*;
import java.util.stream.IntStream;

public class LadderResult {

    private final static int INITIAL = 0;

    private Map<String, String> ladderResult;

    private LadderResult(Map<String, String> ladderResult) {
        this.ladderResult = new LinkedHashMap<>(ladderResult);
    }

    private LadderResult(List<String> names) {
        ladderResult = new LinkedHashMap<>();
        names.stream().forEachOrdered(name -> ladderResult.put(name, ""));
    }

    public static LadderResult of(Map<String, String> ladderResult) {
        return new LadderResult(ladderResult);
    }

    public static LadderResult of(List<String> names) {
        return new LadderResult(names);
    }

    public Map<String, String> getLadderResult() {
        return ladderResult;
    }

    public void findLadderResult(Ladder ladder, List<String> result) {
        List<Integer> resultIndexes = ladder.resultIndexes(ladderResult.size());
        List<String> names = new ArrayList<>();
        ladderResult.keySet().stream().forEachOrdered(name -> names.add(name));

        IntStream.range(INITIAL, resultIndexes.size()).forEachOrdered(index -> {
            ladderResult.put(names.get(index), result.get(resultIndexes.get(index)));
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(ladderResult, that.ladderResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResult);
    }
}


