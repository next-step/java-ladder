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

    public static GameResult of(Ladder ladder, GameInfo gameInfo) {
        return new GameResult(playGame(ladder, gameInfo));
    }

    private static Map<Player, Prize> playGame(Ladder ladder, GameInfo gameInfo) {
        Map<Player, Prize> resultMap = new HashMap<>();
        int numberOfPlayers = gameInfo.numberOfPlayers();

        for (int index = 0; index < numberOfPlayers; index++) {
            Player player = gameInfo.findPlayerByIndex(index);
            Position finalPosition = ladder.goThroughLinesFrom(Position.from(index));
            Prize prize = gameInfo.findPrizeByPosition(finalPosition);

            resultMap.put(player, prize);
        }
        return resultMap;
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
