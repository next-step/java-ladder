package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LadderResult {
    private final Map<Player, Amount> ladderResult;

    public LadderResult() {
        this(new HashMap<>());
    }

    public LadderResult(Map<Player, Amount> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public Amount get(Player player) {
        return this.ladderResult.get(player);
    }

    public void put(Player player, Amount amount) {
        this.ladderResult.put(player, amount);
    }

    public Set<Player> keySet() {
        return this.ladderResult.keySet();
    }

    @Override
    public String toString() {
        return "LadderResult{" +
                "ladderResult=" + ladderResult +
                '}';
    }
}
