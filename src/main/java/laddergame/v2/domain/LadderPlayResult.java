package laddergame.v2.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderPlayResult {
    private final Map<Player, String> results;

    public LadderPlayResult(Map<Player, String> results) {
        this.results = results;
    }

    public String get(Player player) {
        return results.get(player);
    }

    public Map<Player, String> getResults() {
        return new HashMap<>(results);
    }
}
