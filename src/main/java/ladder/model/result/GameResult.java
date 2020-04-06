package ladder.model.result;

import ladder.model.prize.LadderPrizes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private Map<String, String> result;

    public GameResult(Map<String, String> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public static GameResult create(Map<String, Integer> finalLocationByName, LadderPrizes ladderPrizes) {
        Map<String, String> gameResult = new HashMap<>();

        finalLocationByName.keySet().stream()
                .forEach(it -> gameResult.put(it, ladderPrizes.findPrizeNameAtIndex(finalLocationByName.get(it))));

        return new GameResult(gameResult);
    }

    public String findPrizeByPlayerName(String name) {
        return result.get(name);
    }
}