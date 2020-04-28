package ladder.service.type;

import java.util.HashMap;

public class GameResult {
    private HashMap<String, String> gameResult;

    private GameResult() {
        gameResult = new HashMap<>();
    }

    public static final GameResult getInstance() {
        return new GameResult();
    }

    public String get(String personName) {
        return gameResult.get(personName);
    }
}
