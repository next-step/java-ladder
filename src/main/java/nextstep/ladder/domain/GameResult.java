package nextstep.ladder.domain;

import java.util.Map;

public class GameResult {

    private Map<String, String> resultMap;

    public GameResult(Map<String, String> resultMap) {
        this.resultMap = resultMap;
    }

    public String findResultByName(String name) {
        return resultMap.get(name);
    }

    public Map<String, String> getResultMap() {
        return resultMap;
    }
}
