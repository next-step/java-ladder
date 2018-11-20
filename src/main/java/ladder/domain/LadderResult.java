package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class LadderResult {
    private Map<Player, Result> results;

    public LadderResult() {
        results = new HashMap<>();
    }

    public void put(Player player, Result result) {
        results.put(player, result);
    }

    public Result get(Player player) {
        return Optional.ofNullable(results.get(player))
            .orElseThrow(() -> new IllegalArgumentException("참가자가 없습니다."));
    }
    
    public Set<Player> keyset() {
        return results.keySet();
    }
}
