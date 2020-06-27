package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(List<String> names) {
        this.users = createUsers(names);
    }

    private List<User> createUsers(List<String> names) {
        return names.stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }
}
