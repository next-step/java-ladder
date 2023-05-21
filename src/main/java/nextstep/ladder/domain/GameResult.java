package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {
    private final Map<String, String> gameResult;

    public GameResult() {
        this.gameResult = new LinkedHashMap<>();
    }

    public void put(String key, String value) {
        this.gameResult.put(key, value);
    }

    public Map<String, String> getGameResult() {
        return this.gameResult;
    }
}
