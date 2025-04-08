package nextstep.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Users {
    static final User DEFAULT_USER = new User("codesquad", 100);

    List<User> users = Arrays.asList(
            new User("crong", 35),
            new User("pobi", 30),
            new User("jk", 40),
            new User("honux", 45));

    User getUser(String name) {
        return users.stream()
                .map(Optional::ofNullable)
                .filter(user -> user != null && user.get().matchName(name))
                .findFirst()
                .orElse(Optional.of(DEFAULT_USER))
                .get();
    }
}
