package ladder.domain;

import java.util.Map;
import java.util.Set;

public class GameResult {

    private final Map<String, String> gameResult;

    public GameResult(Map<String, String> gameResult) {
        this.gameResult = gameResult;
    }

    public String getGamePrizeNameByPlayerName(String playerName) {
        return gameResult.get(playerName);
    }

    public Set<String> getKeySet() {
        return gameResult.keySet();
    }
}
