package ladder.model.result;

import ladder.model.prize.LadderPrizes;

import java.util.Collections;
import java.util.Map;

public class GameResult {
    private Map<String, String> result;

    public GameResult(Map<String, String> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public static GameResult create(Map<String, Integer> finalLocationByName, LadderPrizes ladderPrizes) {
        return null;
    }

    public String findPrizeByName(String name) {
        return null;
    }
}