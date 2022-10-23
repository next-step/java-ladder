package ladder.domain;

import java.util.List;

public class Users {
    private final List<User> users;

    public Users(UserNames names) {
        this.users = names.toUsers();
    }
}
