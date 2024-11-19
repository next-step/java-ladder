package nextstep.ladder.dto;

import java.util.List;
import java.util.Objects;
import nextstep.ladder.CommaSeparatedResult;

public class LadderResult extends CommaSeparatedResult {
    private final List<String> results;

    public LadderResult(String value) {
        this(convert(value));
    }

    public LadderResult(List<String> results) {
        this.results = results;
    }

    @Override
    public int size() {
        return results.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderResult that = (LadderResult) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
