package nextstep.step4.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LadderResult {
    public Map<Integer, Integer> ladderResult = new HashMap<>();
    public void put(int source, int target) {
        ladderResult.put(source, target);
    }
    public Integer get(int source) {
        return ladderResult.get(source);
    }
    public Set<Integer> keys() {
        return ladderResult.keySet();
    }
}
