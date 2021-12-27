package ladderstep4.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class PlayResult {
    private final Map<Position, Position> result = new HashMap<>();

    public void put(Position start, Position end) {
        result.put(start, end);
    }

    public Position get(Position start) {
        return result.get(start);
    }

    public int size() {
        return result.size();
    }
}
