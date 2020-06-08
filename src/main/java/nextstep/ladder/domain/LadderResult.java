package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LadderResult {

    private final Map<Integer, Integer> results;

    public LadderResult(Map<Integer, Integer> results) {
        this.results = new LinkedHashMap<>(results);
    }

    public Integer get(int position) {
        return results.get(position);
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
