package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LadderResult {

    private final List<String> ladderResults;

    public LadderResult(String... ladderResults) {
        this.ladderResults = Arrays.asList(ladderResults);
    }

    public static LadderResult valueOf(String... ladderResults) {
        return new LadderResult(ladderResults);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderResult)) return false;
        final LadderResult that = (LadderResult) o;
        return Objects.equals(ladderResults, that.ladderResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResults);
    }
}
