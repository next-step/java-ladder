package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ResultMap {
    private final Map<String, String> resultMap;

    private ResultMap(final Map<String, String> resultMap) {
        this.resultMap = resultMap;
    }

    public static ResultMap create(){
        return new ResultMap(new HashMap<>());
    }

    public void put(final String name, final String result) {
        resultMap.put(name, result);
    }

    public Set<String> keySet() {
        return resultMap.keySet();
    }

    public String get(final String key) {
        return resultMap.get(key);
    }
}
