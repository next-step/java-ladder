package ladder.engine;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private Map<Integer, Integer> result = new HashMap<>();

    public void put(int source, int target) {
        result.put(source, target);
    }

    public int getTarget(int source) {
        return result.get(source);
    }
}
