package ladder.domain.user;

import ladder.exception.LadderLackOfUserException;
import ladder.exception.OverlapUserNamesException;

import java.util.List;
import java.util.stream.Collectors;

public final class Users {

    public static final int MIN_USER_COUNT = 2;

    private final List<User> users;

    public Users(final List<String> userNames) {
        validateUserCount(userNames);

        users = userNames.stream()
                .distinct()
                .map(User::valueOf)
                .collect(Collectors.toList());

        if (userNames.size() != users.size()) {
            throw new OverlapUserNamesException();
        }
    }

    private void validateUserCount(final List<String> users) {
        if (users.size() < MIN_USER_COUNT) {
            throw new LadderLackOfUserException();
        }
    }

    public int getUserCount() {
        return users.size();
    }

    public User get(final int index) {
        return users.get(index);
    }
}
