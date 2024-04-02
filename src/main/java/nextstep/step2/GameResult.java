package nextstep.step2;

import java.util.Collections;
import java.util.Map;

public class GameResult {

    private final Map<String, String> resultMap;

    public GameResult(Map<String, String> resultMap) {
        this.resultMap = Collections.unmodifiableMap(resultMap);
    }

    public String getResult(String name) {
        return resultMap.get(name);
    }

    public Map<String, String> getAllResults() {
        return resultMap;
    }
}
