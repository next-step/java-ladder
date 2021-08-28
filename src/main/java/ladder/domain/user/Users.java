package ladder.domain.user;

import ladder.exception.LadderLackOfUserException;
import ladder.exception.OverlapUserNamesException;

import java.util.List;
import java.util.stream.Collectors;

public final class Users {

    public static final int MIN_USER_COUNT = 2;

    private final List<User> users;

    private Users(final List<User> users) {
        this.users = users;
    }

    public static Users of(final List<String> userNames) {
        validateUserCount(userNames);

        List<User> users = userNames.stream()
                .distinct()
                .map(User::valueOf)
                .collect(Collectors.toList());

        if (userNames.size() != users.size()) {
            throw new OverlapUserNamesException();
        }
        return new Users(users);
    }

    private static void validateUserCount(final List<String> userNames) {
        if (userNames.size() < MIN_USER_COUNT) {
            throw new LadderLackOfUserException();
        }
    }

    public int size() {
        return users.size();
    }

    public User get(final int index) {
        return users.get(index);
    }

    public List<User> getUsers() {
        return users;
    }
}
