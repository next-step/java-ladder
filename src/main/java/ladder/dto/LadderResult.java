package ladder.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LadderResult {

    private Map<Integer, Integer> result = new HashMap<>();

    public void put(int source, int target) {
        result.put(source, target);
    }

    public int findTarget(int source) {
        return result.get(source);
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
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
