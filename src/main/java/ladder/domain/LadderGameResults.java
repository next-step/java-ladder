package ladder.domain;

import java.util.Collections;
import java.util.Map;

public class LadderGameResults {
    private final Map<User, LadderReward> results;

    public static LadderGameResults of(Map<User, LadderReward> results) {
        return new LadderGameResults(results);
    }

    private LadderGameResults(Map<User, LadderReward> results) {
        this.results = Collections.unmodifiableMap(results);
    }

    public LadderReward getResult(String userName) {
        return results.get(User.of(userName));
    }

    public Map<User, LadderReward> getResults() {
        return results;
    }
}
