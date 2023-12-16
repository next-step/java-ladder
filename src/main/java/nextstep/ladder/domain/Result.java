package nextstep.ladder.domain;

import java.util.Map;

public class Result {

    private final Map<String, String> map;

    public Result(Map<String, String> map) {
        this.map = map;
    }

    public String putIndexByValue(String key, String name) {
        return map.put(key, name);
    }

    public Map<String, String> getMap() {
        return map;
    }
}
