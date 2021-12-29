package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class UserResults {

    private final List<UserResult> userResults;

    private UserResults(List<UserResult> userResults) {
        this.userResults = new ArrayList<>(userResults);
    }

    public static UserResults from(List<UserResult> userResults) {
        validate(userResults);
        return new UserResults(userResults);
    }

    private static void validate(List<UserResult> userResults) {
        if (Objects.isNull(userResults)) {
            throw new IllegalArgumentException("전달된 사용자 결과들이 null 입니다.");
        }
        if (userResults.isEmpty()) {
            throw new IllegalArgumentException("전달된 사용자 결과들이 비어있습니다.");
        }
    }

    public List<UserResult> getUserResults() {
        return Collections.unmodifiableList(userResults);
    }
}
