package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Users {
    List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public static Users of(List<String> names) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            users.add(new User(names.get(i)));
        }
        return new Users(users);
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }
}
