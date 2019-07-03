package nextstep.optional;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class Users {
    static final User DEFAULT_USER = new User("codesquad", 100);

    List<User> users = Arrays.asList(
            new User("crong", 35),
            new User("pobi", 30),
            new User("jk", 40),
            new User("honux", 45));

    User getUser(String name) {
        for (User user : users) {
            if (user.matchName(name)) {
                return user;
            }
        }
        return DEFAULT_USER;
    }

    public User getUserOptional(String name) {
        // param으로 name input
        // List users에서 한개씩 가져와'
        // 이름이 매치될 경우 user를 리턴
        return users.stream().filter(user -> user.matchName(name))
                .findFirst()
                .orElse(DEFAULT_USER);

    }
}
