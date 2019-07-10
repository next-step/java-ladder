package ladder.domain.user;

import ladder.common.PositiveNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderUsers {
    private static final Integer USERNAME_MAX_LEN = 5;

    private List<Username> usernames;

    private LadderUsers(List<Username> usernames) {
        validateNameLength(usernames);
        this.usernames = usernames;
    }

    public static LadderUsers of(List<String> usernames) {
        return new LadderUsers(usernames.stream()
                .map(Username::of)
                .collect(Collectors.toList()));
    }

    private void validateNameLength(List<Username> usernames) {
        usernames.stream()
                .filter(username -> username.length() > USERNAME_MAX_LEN)
                .findFirst()
                .ifPresent(username -> { throw new IllegalArgumentException("Username length is over 5"); });
    }

    public List<Username> getUsernames() {
        return Collections.unmodifiableList(usernames);
    }

    public int getUserIndex(Username username) {
        return usernames.indexOf(username);
    }

    public PositiveNumber getCountOfUsers() {
        return PositiveNumber.of(usernames.size());
    }
}
