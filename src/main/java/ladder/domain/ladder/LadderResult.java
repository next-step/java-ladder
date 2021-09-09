package ladder.domain.ladder;

import java.util.Collections;
import java.util.Map;
import ladder.domain.user.User;

public class LadderResult {

    private static final String INVALID_CONTAINS_USER_ERROR_MESSAGE = "입력된 사람의 결과만 확인할 수 있다.";

    private final Map<User, String> results;

    public LadderResult(Map<User, String> results) {
        this.results = results;
    }

    public String getResultByUser(User user) {
        checkContainsUser(user);

        return results.get(user);
    }

    private void checkContainsUser(User user) {
        if (!results.containsKey(user)) {
            throw new IllegalArgumentException(INVALID_CONTAINS_USER_ERROR_MESSAGE);
        }
    }

    public Map<User, String> getAllResults() {
        return Collections.unmodifiableMap(results);
    }

}
