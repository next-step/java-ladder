package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderResults {
    private final Map<String, LadderResult> map;

    private LadderResults(Map<String, LadderResult> map) {
        this.map = map;
    }

    public static LadderResults of() {
        return new LadderResults(new HashMap<>());
    }

    public void put(String name, String prize) {
        LadderResult ladderResult = new LadderResult(name, prize);
        map.put(name, ladderResult);
    }

    public Map<String, LadderResult> values() {
        return Collections.unmodifiableMap(map);
    }
}
