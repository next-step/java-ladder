package domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {

    private final Map<Player, String> ladderResult = new HashMap<>();
    public void put(Player player, String result) {
        ladderResult.put(player, result);
    }

    public String get(Player player) {
        return ladderResult.get(player);
    }
}
