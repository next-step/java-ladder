package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class LadderResults {

    private final List<String> ladderResults;

    public LadderResults(List<String> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public static final LadderResults of(String[] ladderResults) {
        return of(mapToLadderResultList(ladderResults));
    }

    private static final List<String> mapToLadderResultList(String[] ladderResults) {
        return Arrays.stream(ladderResults).collect(Collectors.toList());
    }

    public static final LadderResults of(List<String> ladderResults) {
        return new LadderResults(ladderResults);
    }

    public String get(int index) {
        return ladderResults.get(index);
    }
}
