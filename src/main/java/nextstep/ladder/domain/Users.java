package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class Users {
    private final Set<User> users;

    public Users(Set<User> users) {
        this.users = users;
    }

    public static Users from(Set<String> userNames) {
        Set<User> userSet = userNames.stream()
                .map(User::new)
                .collect(Collectors.toSet());
        return new Users(userSet);
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }

    public int size() {
        return users.size();
    }
}
