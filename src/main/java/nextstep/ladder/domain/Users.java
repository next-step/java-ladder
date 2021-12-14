package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public static Users createByString(String users) {
        return new Users(Arrays.stream(users.split(","))
            .map(user -> new User(Name.of(user)))
            .collect(Collectors.toList()));
    }

    public List<User> getUsers() {
        return users;
    }
}
