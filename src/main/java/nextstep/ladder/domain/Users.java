package nextstep.ladder.domain;

import java.util.List;

public class Users {

    private List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }

    public static Users create(List<User> users) {
        return new Users(users);
    }

    public int size() {
        return users.size();
    }

    public List<User> getUsers() {
        return users;
    }
}
