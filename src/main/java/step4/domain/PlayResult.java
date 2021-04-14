package step4.domain;

import java.util.HashMap;
import java.util.Map;

public class PlayResult {
    private final Map<Player, Prize> result;

    public PlayResult() {
        result = new HashMap<>();
    }

    public void addResult(Player player, Prize prize) {
        result.put(player, prize);
    }

    public Prize matchPlayer(Player matchPlayer) {
        return result.get(matchPlayer);
    }

    public Map<Player, Prize> getResult() {
        return result;
    }
}
