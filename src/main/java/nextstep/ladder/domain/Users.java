package nextstep.ladder.domain;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Users {
    private final LinkedHashSet<User> users;

    private Users(LinkedHashSet<User> users) {
        this.users = users;
    }

    public static Users from(Set<String> userNames) {
        LinkedHashSet<User> userSet = userNames.stream()
                .map(User::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return new Users(userSet);
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }

    public int size() {
        return users.size();
    }
}
