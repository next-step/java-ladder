package ladder.domain.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(final String... userNames) {
        this.users = Arrays.stream(userNames)
                .map(User::new)
                .collect(Collectors.toList());
    }

    public int getUserCount() {
        return users.size();
    }
}
