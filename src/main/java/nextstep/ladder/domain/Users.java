package nextstep.ladder.domain;

import java.util.List;

import nextstep.ladder.domain.User;

public class Users {
    private List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public int getCountOfPerson() {
        return users.size();
    }

    public List<User> getUsers() {
        return users;
    }
}
