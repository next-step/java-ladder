package ladder.domain.model;

import ladder.common.PositiveNumber;

import java.util.Collections;
import java.util.List;

public class Users {
    private static final Integer USERNAME_MAX_LEN = 5;

    private List<String> userNames;

    private Users(List<String> userNames) {
        validateNameLength(userNames);
        this.userNames = userNames;
    }

    public static Users of(List<String> userNames) {
        return new Users(userNames);
    }

    private void validateNameLength(List<String> userNames) {
        userNames.stream()
                .filter(userName -> userName.length() > USERNAME_MAX_LEN)
                .findFirst()
                .ifPresent(userName -> { throw new IllegalArgumentException("Username length is over 5"); });
    }

    public List<String> getUserNames() {
        return Collections.unmodifiableList(userNames);
    }

    public PositiveNumber getCountOfUsers() {
        return PositiveNumber.of(userNames.size());
    }
}
