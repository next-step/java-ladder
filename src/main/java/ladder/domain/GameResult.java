package ladder.domain;

import java.util.Map;
import java.util.Set;

public class GameResult {
    private static final String INVALID_PLAYER_NAME_MESSAGE = "해당 이름의 참가자는 존재하지 않습니다.";

    private final Map<String, String> gameResult;

    public GameResult(Map<String, String> gameResult) {
        this.gameResult = gameResult;
    }

    public Set<String> getKeySet() {
        return gameResult.keySet();
    }

    public String getGamePrizeNameByPlayerName(String playerName) {
        return gameResult.getOrDefault(playerName, INVALID_PLAYER_NAME_MESSAGE);
    }
}
