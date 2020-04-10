package nextstep.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Users {
    static final User DEFAULT_USER = new User("codesquad", 100);

    List<User> users = Arrays.asList(
            new User("crong", 35),
            new User("pobi", 30),
            new User("jk", 40),
            new User("honux", 45));

    // TODO 깔끔하지 않은 것 같은데 개선방안이 있을지요?
    User getUser(String name) {
        Optional<User> u = users.stream().filter(
                (user) -> user.matchName(name) ).findFirst();
        u = Optional.ofNullable(u).orElse(Optional.of(Users.DEFAULT_USER));

        return u.orElse(Users.DEFAULT_USER);
    }
}
