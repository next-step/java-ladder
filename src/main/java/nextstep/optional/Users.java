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
    
    User getUser(String name) {
        users = users.stream().filter(user -> user.matchName(name)).collect(Collectors.toList());
        if (!users.isEmpty()) {
            return Optional.ofNullable(users.get(0)).orElse(DEFAULT_USER);
        }
        return DEFAULT_USER;
    }
}

