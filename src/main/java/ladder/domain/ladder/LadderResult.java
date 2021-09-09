package ladder.domain.ladder;

import java.util.Map;
import ladder.domain.user.User;

public class LadderResult {

    private final Map<User, String> results;

    public LadderResult(Map<User, String> results) {
        this.results = results;
    }

    public String getResultByUser(User user) {
        return results.get(user);
    }

}
