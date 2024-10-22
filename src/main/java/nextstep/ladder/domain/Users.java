package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Set;

public class Users {
    private final Set<User> users;

    public Users(Set<User> users) {
        this.users = users;
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }

    public int size() {
        return users.size();
    }
}
