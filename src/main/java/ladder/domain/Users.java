package ladder.domain;

import java.util.List;
import java.util.Set;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public int count() {
        return users.size();
    }
}
