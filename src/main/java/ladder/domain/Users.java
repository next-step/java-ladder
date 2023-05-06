package ladder.domain;

import java.util.Set;

public class Users {
    Set<User> users;

    public int count() {
        return users.size();
    }
}
