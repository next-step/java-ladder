package ladder.model;

import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private final Map<User, Result> gameResult = new HashMap<>();

    public void put(User user, Result result) {
        gameResult.put(user, result);
    }

    public Map<User, Result> getGameResult() {
        return gameResult;
    }
}
