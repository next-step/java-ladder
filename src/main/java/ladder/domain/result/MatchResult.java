package ladder.domain.result;

import ladder.domain.player.Player;

import java.util.Map;

public class MatchResult {

    private final Map<Player, LadderResult> result;

    public MatchResult(Map<Player, LadderResult> result) {
        this.result = result;
    }

    public LadderResult get(Player player) {
        return result.get(player);
    }
}
