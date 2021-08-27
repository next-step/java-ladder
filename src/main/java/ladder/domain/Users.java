package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Users {
    private final List<User> users;

    public Users(String[] usersName) {
        List<User> users = new ArrayList<>();
        for (String name : usersName) {
            User user = new User(name);
            users.add(user);
        }
        this.users = users;
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }
}
