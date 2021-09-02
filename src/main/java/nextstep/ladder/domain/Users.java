package nextstep.ladder.domain;

import java.util.List;

public class Users {
    private List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public int userCount() {
        return users.size();
    }

    public List<User> getValue() {
        return this.users;
    }
}
