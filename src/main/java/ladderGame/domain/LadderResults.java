package ladderGame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResults {

    private final List<Result> results;

    private LadderResults(List<String> results) {
        this.results = IntStream.range(0, results.size())
                .mapToObj(index -> Result.of(results.get(index), index))
                .collect(Collectors.toList());
    }

    public static LadderResults of(List<String> results) {
        return new LadderResults(results);
    }

    public Result getResult(Position position) {
        return results.stream()
                .filter(result -> result.isEquals(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 Position이 없습니다. "));
    }
}
