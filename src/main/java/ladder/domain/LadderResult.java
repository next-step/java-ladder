package ladder.domain;

import java.util.Collections;
import java.util.Map;

public class LadderResult {

    private final Map<Integer, Integer> resultMap;

    public LadderResult(Map<Integer, Integer> resultMap) {
        this.resultMap = Collections.unmodifiableMap(resultMap);
    }

    public Integer get(int index) {
        return resultMap.get(index);
    }
}
