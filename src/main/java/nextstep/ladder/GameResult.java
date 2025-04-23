package nextstep.ladder;

import java.util.*;

public class GameResult {
    private final Map<Player, Prize> resultMap;

    public GameResult(Map<Player, Prize> resultMap) {
        this.resultMap = new LinkedHashMap<>(resultMap);
    }

    public Prize getResult(Player player) {
        return resultMap.get(player);
    }

    public String getResult(String name) {
        return resultMap.entrySet().stream()
                .filter(entry -> entry.getKey().getName().equals(name))
                .map(entry -> entry.getValue().getName())
                .findFirst()
                .orElse(null);
    }

    public Map<Player, Prize> getAllResults() {
        return Collections.unmodifiableMap(resultMap);
    }
}