package domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {

    private final Map<Player, String> ladderResult = new HashMap<>();
    public void addResult(Player player, String result) {
        ladderResult.put(player, result);
    }

    public String getResult(Player player) {
        return ladderResult.get(player);
    }

    public String getResult(String player) {
        return ladderResult.get(Player.from(player));
    }
}
