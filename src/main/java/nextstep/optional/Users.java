package nextstep.optional;

import java.util.Arrays;
import java.util.List;

public class Users {
    static final User DEFAULT_USER = new User("codesquad", 100);

    List<User> users = Arrays.asList(
            new User("crong", 35),
            new User("pobi", 30),
            new User("jk", 40),
            new User("honux", 45));

    User getUser2(String name) {
        for (User user : users) {
            if (user.matchName(name)) {
                return user;
            }
        }
        return DEFAULT_USER;
    }

    User getUser(String name) {
        return users.stream().filter(user -> user.matchName(name))
                .findFirst()
                .orElse(DEFAULT_USER);
    }
}
