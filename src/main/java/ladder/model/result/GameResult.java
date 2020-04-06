package ladder.model.result;

import ladder.model.player.PlayerName;
import ladder.model.prize.LadderPrizes;
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

    public static GameResult create(Map<PlayerName, Integer> finalLocationByName, LadderPrizes ladderPrizes) {
        Map<PlayerName, PrizeName> gameResult = new HashMap<>();

        finalLocationByName.keySet().stream()
                .forEach(it -> gameResult.put(it, ladderPrizes.findPrizeNameAtIndex(finalLocationByName.get(it))));

        return new GameResult(gameResult);
    }

    public PrizeName findPrizeByPlayerName(String name) {
        return result.get(new PlayerName(name));
    }

    public Map<PlayerName, PrizeName> getResult() {
        return result;
    }

    public Set<PlayerName> getKeySet() {
        return result.keySet();
    }
}