package nextstep.ladder.domain;

import java.util.Map;

public class ResultMap {
    private final Map<String, String> resultMap;

    ResultMap(Map<String, String> resultMap) {
        this.resultMap = resultMap;
    }

    public String getResult(String key) {
        return resultMap.get(key);
    }
}
