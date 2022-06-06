package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private Map<Position, Position> result = new HashMap<>();

    public void put(Position participant, Position goal) {
        result.put(participant, goal);
    }

    public Position goalOf(Position participant) {
        return result.get(participant);
    }

    @Override
    public String toString() {
        return "LadderResult{" +
                "result=" + result +
                '}';
    }
}
