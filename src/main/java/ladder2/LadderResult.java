package ladder2;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {

    private final Map<String, String> results;

    public LadderResult(Map<String, String> results) {
        this.results = results;
    }

    public String getOneResult(String player) {
        return results.get(player);
    }

    public Map<String, String> getResults() {
        return new HashMap<>(results);
    }

    public String getOne(String personName) {
        if (!results.containsKey(personName)) {
            throw new IllegalArgumentException();
        }
        return results.get(personName);
    }
}
