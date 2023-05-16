package step3.domain;

import java.util.Map;

public class PlayerResult {
    private final Map<String, String> playerResultMap;

    public PlayerResult(Map<String, String> playerResultMap) {
        this.playerResultMap = playerResultMap;
    }

    public Map<String, String> getPlayerResultMap() {
        return playerResultMap;
    }

    public String getResultMapByKey(String player) {
        return playerResultMap.get(player);
    }
}
