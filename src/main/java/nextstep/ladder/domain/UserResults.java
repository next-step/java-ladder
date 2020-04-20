package nextstep.ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserResults {
    private Map<String, Result> userResults;

    public UserResults(Map<String, Result> userResults) {
        this.userResults = Collections.unmodifiableMap(new LinkedHashMap<>(userResults));
    }

    public Map<String, Result> getUserResults() {
        return userResults;
    }
}
