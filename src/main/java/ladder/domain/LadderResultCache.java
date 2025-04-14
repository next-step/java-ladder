package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toUnmodifiableMap;

public class LadderResultCache {
    private final List<LadderResult> ladderResults;
    private final Map<String, LadderResult> ladderResultMap;

    public LadderResultCache(List<LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
        this.ladderResultMap = createLadderResultMap(ladderResults);
    }

    private Map<String, LadderResult> createLadderResultMap(List<LadderResult> results) {
        return results.stream()
            .collect(
                toUnmodifiableMap(
                    LadderResult::getName,
                    Function.identity()
                )
            );
    }

    public List<LadderResult> getSortedResults() {
        return ladderResults.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    public String getResult(String userName) {
        return ofNullable(ladderResultMap.get(userName))
            .map(LadderResult::getResult)
            .orElseThrow(IllegalArgumentException::new);
    }
}
