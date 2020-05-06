package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LadderResult {
    private Map<String, String> results;

    public LadderResult(Map<String, String> results) {
        this.results = results;
    }

    public String findPlayerGoal(String playerName) {
        return results.get(playerName);
    }
    public Map<String, String> getAll() {
        return new HashMap<>(results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderResult)) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
