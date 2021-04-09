package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class MatchResult {
    private final Map<Player, Prize> result;

    public MatchResult() {
        result = new HashMap<>();
    }

    public void addMatchResult(Player player, Prize prize) {
        result.put(player, prize);
    }

    public Prize matchPlayer(Player matchPlayer) {
        return result.get(matchPlayer);
    }

    public Map<Player, Prize> getMatchResult() {
        return result;
    }
}
