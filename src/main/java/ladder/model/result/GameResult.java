package ladder.model.result;

import ladder.model.player.PlayerName;
import ladder.model.prize.LadderPrizes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameResult {
    private Map<PlayerName, String> result;

    public GameResult(Map<PlayerName, String> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public static GameResult create(Map<PlayerName, Integer> finalLocationByName, LadderPrizes ladderPrizes) {
        Map<PlayerName, String> gameResult = new HashMap<>();

        finalLocationByName.keySet().stream()
                .forEach(it -> gameResult.put(it, ladderPrizes.findPrizeNameAtIndex(finalLocationByName.get(it))));

        return new GameResult(gameResult);
    }

    public String findPrizeByPlayerName(String name) {
        return result.get(new PlayerName(name));
    }

    public Map<PlayerName, String> getResult() {
        return result;
    }

    public Set<PlayerName> getKeySet() {
        return result.keySet();
    }
}