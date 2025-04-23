package nextstep.ladder;

import java.util.*;

public class GameResult {
    private final Map<String, String> resultMap;

    public GameResult(Map<String, String> resultMap) {
        this.resultMap = new LinkedHashMap<>(resultMap);
    }

    public String getResult(String playerName) {
        return resultMap.get(playerName);
    }

    public Map<String, String> getAllResults() {
        return Collections.unmodifiableMap(resultMap);
    }

}
