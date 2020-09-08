package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LadderResult {

    private final Map<Name, Integer> results;

    public LadderResult(Map<Name, Integer> results) {
        this.results = results;
    }

    public static LadderResult of() {
        Map<Name, Integer> result = new LinkedHashMap<>();
        return new LadderResult(result);
    }

    public void addResult(Name name, int position) {
        results.put(name, position);
    }

    public int findResultByName(Name name) {
        return results.get(name);
    }

    public Set<Name> getAllNames() {
        return results.keySet();
    }
}
