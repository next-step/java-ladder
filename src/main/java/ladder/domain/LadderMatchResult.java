package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderMatchResult {
    private Map<Integer, Integer> matchResult;

    public LadderMatchResult() {
        this.matchResult = new HashMap<>();
    }

    public void put(int startIndex, int lastIndex) {
        matchResult.put(startIndex, lastIndex);
    }

    public int get(int startIndex) {
        return matchResult.get(startIndex);
    }
}
