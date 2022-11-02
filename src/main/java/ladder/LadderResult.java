package ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {

    // index, position
    private Map<Integer, Position> result;

    private LadderResult(Map<Integer, Position> result) {
        this.result = result;
    }

    public static LadderResult of(int people) {
        Map<Integer, Position> result = new HashMap<>();
        for (int index = 0; index < people; index++) {
            result.put(index, new Position(index));
        }
        return new LadderResult(result);
    }

    public void put(int index, Position position) {
        result.put(index, position);
    }

    public Position getTarget(int index) {
        return result.get(index);
    }

    public List<Position> getValues() {
        return new ArrayList<>(result.values());
    }
}
