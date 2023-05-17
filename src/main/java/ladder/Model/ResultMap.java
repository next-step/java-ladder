package ladder.Model;

import java.util.HashMap;
import java.util.Map;

public class ResultMap {
    private final Map<String, Integer> resultMap = new HashMap<>();

    public ResultMap(){}

    public void put(String key, Integer value) {
        resultMap.put(key, value);
    }

    public Integer get(String key) {
        return resultMap.get(key);
    }

    public Map<String, Integer> of() {
        return resultMap;
    }
}
