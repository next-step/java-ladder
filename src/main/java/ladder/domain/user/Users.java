package ladder.domain.user;

import ladder.exception.OverlapUserNamesException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(final String... userNames) {
        this(Arrays.asList(userNames));
    }

    public Users(final List<String> userNames) {
        users = userNames.stream()
                .distinct()
                .map(User::new)
                .collect(Collectors.toList());

        if (userNames.size() != users.size()) {
            throw new OverlapUserNamesException();
        }
    }

    public int getUserCount() {
        return users.size();
    }
}
