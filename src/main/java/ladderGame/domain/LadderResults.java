package ladderGame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResults {

    private final List<LadderResult> ladderResults;

    private LadderResults(List<String> results) {
        this.ladderResults = IntStream.range(0, results.size())
                .mapToObj(index -> LadderResult.of(results.get(index), index))
                .collect(Collectors.toList());
    }

    public static LadderResults of(List<String> results) {
        return new LadderResults(results);
    }

    public String getResult(Position position) {
        return ladderResults.stream()
                .filter(ladderResult -> ladderResult.isEquals(position))
                .map(LadderResult::getContent)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 Position이 없습니다. "));
    }

    public int size() {
        return ladderResults.size();
    }

    public List<LadderResult> getLadderResults() {
        return ladderResults;
    }
}
