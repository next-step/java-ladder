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

    private static void validate(List<UserResult> userResults) {
        if (Objects.isNull(userResults)) {
            throw new IllegalArgumentException("사용자 결과가 null입니다.");
        }
        if (userResults.isEmpty()) {
            throw new IllegalArgumentException("사용자 결과가 비어있습니다.");
        }
    }
}
