package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private static final String ALERT_FOR_INVALID_PLAYER_NAME = "입력하신 플레이어는 존재하지 않습니다.";

    private final Map<Player, Prize> resultMap;

    private GameResult(Map<Player, Prize> resultMap) {
        this.resultMap = new HashMap<>(resultMap);
    }

    public static GameResult from(Map<Player, Prize> resultMap) {
        return new GameResult(resultMap);
    }

    public String findResult(String wantedPlayer) {
        Player playerWanted = resultMap.keySet().stream()
                .filter(player -> player.isSame(wantedPlayer))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ALERT_FOR_INVALID_PLAYER_NAME));

        return resultMap.get(playerWanted).getPrize();
    }

    public Map<Player, Prize> getResultMap() {
        return Collections.unmodifiableMap(resultMap);
    }
}
