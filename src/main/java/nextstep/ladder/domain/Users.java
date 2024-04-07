package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public Users(String... userNames) {
        this(Arrays.stream(userNames)
                .map(User::new)
                .collect(Collectors.toList()));
    }

    public int getUserCount() {
        return users.size();
    }
}
