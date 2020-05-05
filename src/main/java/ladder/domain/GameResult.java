package ladder.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {
    private Map<String, String> gameResult;

    private GameResult() {
        gameResult = new LinkedHashMap<>();
    }

    public static final GameResult getInstance() {
        return new GameResult();
    }

    public String get(String personName) {
        return gameResult.get(personName);
    }

    public void put(String userName, String resultValue) {
        gameResult.put(userName, resultValue);
    }

    public boolean isContains(String name) {
        return gameResult.containsKey(name);
    }

    public Map<String, String> getGameResult() {
        return new HashMap<>(gameResult);
    }
}
