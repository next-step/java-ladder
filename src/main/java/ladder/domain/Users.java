package ladder.domain;

import java.util.List;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = List.copyOf(users);
    }

    public int count() {
        return users.size();
    }

    public List<User> getUsers() {
        return List.copyOf(users);
    }
}
