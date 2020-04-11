package ladder.model.result;

import ladder.model.player.PlayerName;
import ladder.model.prize.PrizeName;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameResult {
    private Map<PlayerName, PrizeName> result;

    public GameResult(Map<PlayerName, PrizeName> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public static GameResult of(Map<PlayerName, PrizeName> result) {
        return new GameResult(result);
    }

    public GameResult findResultByPlayerName(String name) {
        Map<PlayerName, PrizeName> result = new HashMap<>();
        result.put(PlayerName.of(name), PrizeName.of(findPrizeByPlayerName(name)));
        return GameResult.of(result);
    }

    public String findPrizeByPlayerName(String name) {
        return result.get(new PlayerName(name)).getPrizeName();
    }

    public Set<PlayerName> getKeySet() {
        return result.keySet();
    }
}