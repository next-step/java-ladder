package ladder.domain.ladder;

import ladder.exception.StringListNullPointerException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LadderResults {

    private static final int START_INCLUSIVE = 0;

    private final List<String> ladderResults;

    public static final LadderResults of(String[] ladderResults) {
        return of(mapToLadderResultList(ladderResults));
    }

    private static final List<String> mapToLadderResultList(String[] ladderResults) {
        return Arrays.stream(ladderResults).collect(Collectors.toList());
    }

    public static final LadderResults of(List<String> ladderResults) {
        return new LadderResults(ladderResults);
    }

    public LadderResults(List<String> ladderResults) {
        validateNull(ladderResults);
        this.ladderResults = ladderResults;
    }

    private final void validateNull(List<String> ladderResults) {
        if (Objects.isNull(ladderResults)) {
            throw new StringListNullPointerException();
        }
    }

    public String get(int index) {
        return ladderResults.get(index);
    }

    public List<Integer> values() {
        return IntStream.range(START_INCLUSIVE, ladderResults.size())
                .boxed()
                .collect(Collectors.toList());
    }
}
