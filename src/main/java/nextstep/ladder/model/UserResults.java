package nextstep.ladder.model;

import java.util.List;
import java.util.Objects;

public final class UserResults {

    private final List<UserResult> userResults;

    private UserResults(List<UserResult> userResults) {
        this.userResults = userResults;
    }

    public static UserResults from(List<UserResult> userResults) {
        validate(userResults);
        return new UserResults(userResults);
    }
}
