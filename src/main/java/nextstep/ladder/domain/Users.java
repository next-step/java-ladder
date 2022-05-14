package nextstep.ladder.domain;

import java.util.List;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return this.users.toString();
    }
}
