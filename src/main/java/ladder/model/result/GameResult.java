package ladder.model.result;

import ladder.model.player.PlayerName;
import ladder.model.prize.PrizeName;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class GameResult {
    private Map<PlayerName, PrizeName> result;

    public GameResult(Map<PlayerName, PrizeName> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public String findPrizeByPlayerName(String name) {
        return result.get(new PlayerName(name)).getPrizeName();
    }

    public Set<PlayerName> getKeySet() {
        return result.keySet();
    }
}