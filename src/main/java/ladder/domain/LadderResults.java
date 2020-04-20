package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LadderResults {
    private final Map<Position, Position> results;

    public LadderResults(Map<Position, Position> results) {
        this.results = Collections.unmodifiableMap(new HashMap<>(results));
    }

    public Position getResultPosition(int position) {
        return results.get(new Position(position));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderResults)) return false;
        LadderResults that = (LadderResults) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
