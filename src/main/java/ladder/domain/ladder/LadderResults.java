package ladder.domain.ladder;

import java.util.Collections;
import java.util.Map;

public class LadderResults {
    private final Map<Position, Position> results;

    public LadderResults(Map<Position, Position> results) {
        this.results = Collections.unmodifiableMap(results);
    }

    public Position getResultPosition(int position) {
        return results.get(new Position(position));
    }

}

