package domain;

import java.util.Map;

public class LadderResult {

    private final Map<Player, String> ladderResult;

    public LadderResult(Map<Player, String> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public String getResult(Player player) {
        return ladderResult.get(player);
    }

    public String getResult(String player) {
        return ladderResult.get(Player.from(player));
    }
}
