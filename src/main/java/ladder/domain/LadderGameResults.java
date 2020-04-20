package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LadderGameResults {
    private final Map<User, LadderReward> results;

    public LadderGameResults(Map<User, LadderReward> results) {
        this.results = Collections.unmodifiableMap(new HashMap<>(results));
    }

    public LadderReward getLadderReward(String userName) {
        return results.get(new User(userName));
    }

    public Map<User, LadderReward> getResults() {
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderGameResults)) return false;
        LadderGameResults that = (LadderGameResults) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
