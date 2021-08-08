package nextstep.ladder.ladder.dto;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private final Map<Integer, Integer> gameResult = new HashMap<>();

    public void put(int source, int target) {
        gameResult.put(source, target);
    }

    public int getTarget(int source) {
        return gameResult.get(source);
    }
}
