package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Users {

    private List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public int size() {
        return users.size();
    }

}
