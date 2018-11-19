package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private Map<Player, Result> results;

    public LadderResult() {
        results = new HashMap<>();
    }

    public void put(Player player, Result result) {
        results.put(player, result);
    }

    public Result get(Player player) {
        return results.get(player);
    }
}
