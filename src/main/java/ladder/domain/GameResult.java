package ladder.domain;

import java.util.Map;

public class GameResult {

    private final Map<String, String> gameResult;

    public GameResult(Map<String, String> gameResult) {
        this.gameResult = gameResult;
    }

    public String getResultByPlayerName(String playerName) {
        return gameResult.get(playerName);
    }
}
