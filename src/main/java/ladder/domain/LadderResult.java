package ladder.domain;

import java.util.Map;

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
}
