package nextstep.step4.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LadderResult {
    private final Map<Integer, Integer> resultMap;

    public LadderResult() {
        this(new HashMap<>());
    }

    public LadderResult(Map<Integer, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public void put(int key, int value) {
        resultMap.put(key, value);
    }

    public Map<Integer, Integer> get() {
        return Collections.unmodifiableMap(this.resultMap);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        LadderResult that = (LadderResult) other;
        return Objects.equals(resultMap, that.resultMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultMap);
    }
}
