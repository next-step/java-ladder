package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Users {

    private final List<User> users;

    private Users(List<User> users) {
        this.users = new ArrayList<>(users);
    }

    public static Users from(List<User> users) {
        return new Users(users);
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public int size() {
        return users.size();
    }
}
