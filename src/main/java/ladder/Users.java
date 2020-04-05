package ladder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private static final String USER_SEPARATOR = ",";

    private final List<User> users;

    public static Users of(String users) {
        return new Users(Arrays.stream(users.split(USER_SEPARATOR))
                .map(User::of)
                .collect(Collectors.toList()));
    }

    public Users(List<User> users) {
        this.users = Collections.unmodifiableList(users);
    }

    public List<User> getUsers() {
        return users;
    }
}
