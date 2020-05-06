package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private Map<String, String> results;

    public LadderResult(Map<String, String> results) {
        this.results = results;
    }

    public String findPlayerGoal(String playerName) {
        return results.get(playerName);
    }
    public Map<String, String> getAll() {
        return new HashMap<>(results);
    }
}
