package ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class LadderResult {

    private final Map<Integer, Integer> resultIndices;

    private LadderResult(Map<Integer, Integer> resultIndices) {
        this.resultIndices = resultIndices;
    }

    public static LadderResult from(Map<Integer, Integer> resultIndices) {
        return new LadderResult(Collections.unmodifiableMap(resultIndices));
    }

    public Integer resultIndexOf(int index) {
        return resultIndices.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderResult that = (LadderResult) o;
        return Objects.equals(resultIndices, that.resultIndices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultIndices);
    }

    @Override
    public String toString() {
        return "LadderResult{" +
            "resultIndices=" + resultIndices +
            '}';
    }
}
