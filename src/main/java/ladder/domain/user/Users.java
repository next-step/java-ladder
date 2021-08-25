package ladder.domain.user;

import ladder.exception.LadderLackOfUserException;
import ladder.exception.OverlapUserNamesException;

import java.util.List;
import java.util.stream.Collectors;

public class Users {

    public static final int MIN_USER_COUNT = 2;

    private final List<User> users;

    public Users(final List<String> userNames) {
        validateUserCount(userNames);

        users = userNames.stream()
                .distinct()
                .map(User::new)
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

    public int indexOf(String username) {
        return users.indexOf(new User(username));
    }

    public User get(int index) {
        return users.get(index);
    }

}
