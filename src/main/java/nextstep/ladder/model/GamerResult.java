package nextstep.ladder.model;

import java.util.HashMap;
import java.util.Map;

public class GamerResult {
    private final Map<String, String> results = new HashMap<>();

    public void addResult(String name, String result) {
        results.put(name, result);
    }

    public String getResultByName(String name) {
        return results.get(name);
    }

    public Map<String, String> getResults() {
        return results;
    }
}
