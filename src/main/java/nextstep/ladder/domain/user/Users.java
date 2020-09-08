package nextstep.ladder.domain.user;

import nextstep.ladder.utils.LadderValidation;

import java.util.Collections;
import java.util.List;

public class Users {

    private List<User> users;

    private Users(List<User> users) {
        this.users = users;
        LadderValidation.validateCountOfUser(users.size());
    }

    public static Users from(List<User> users) {
        return new Users(users);
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public int size() {
        return users.size();
    }

}
