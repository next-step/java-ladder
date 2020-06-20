package ladder.domain.ladder;

import java.util.Collections;
import java.util.Map;

public class LadderResults {
    private final Map<Position, Position> results;

    public LadderResults(Map<Position, Position> results) {
        this.results = Collections.unmodifiableMap(results);
    }

    public Position getResultPosition(int position) {
        validate(position);
        return results.get(new Position(position));
    }

    private void validate(int position) {
        if(!results.containsKey(new Position(position))) {
            throw new IllegalArgumentException("유효하지 않은 포지션을 입력했습니다.");
        }
    }

}

