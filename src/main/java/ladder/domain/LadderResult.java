package ladder.domain;

import java.util.Map;
import java.util.Objects;

public class LadderResult {
    private final Map<Integer, Integer> map;

    public LadderResult(Map<Integer, Integer> map) {
        this.map = map;
    }

    public int move(int i) {
        if (i >= map.size()) {
            throw new IllegalArgumentException();
        }

        return map.get(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(map, that.map);
    }

    @Override
    public int hashCode() {

        return Objects.hash(map);
    }

    @Override
    public String toString() {
        return "LadderResult{" +
                "map=" + map +
                '}';
    }
}
