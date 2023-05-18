package step3.domain;

import java.util.HashMap;
import java.util.Map;

public class PlayerResult {
    private final Map<String, String> playerResultMap;
    private final Position[] positions;

    public PlayerResult(Players players, Results results, Position[] positions) {
        this.positions = positions;
        this.playerResultMap = getResult(players, results);
    }

    public Map<String, String> getResult(Players players, Results results) {
        Map<String, String> playerResultMap = new HashMap<>();

        for (int i = 0; i < positions.length; i++) {
            Player player = players.getPlayers().get(i);
            Result result = results.getResults().get(positions[i].position);
            playerResultMap.put(player.getName(), result.getResult());
        }

        return playerResultMap;
    }

    public Map<String, String> getPlayerResultMap() {
        return playerResultMap;
    }

    public String getResultMapByKey(String player) {
        return playerResultMap.get(player);
    }
}
