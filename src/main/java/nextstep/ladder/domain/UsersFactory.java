package nextstep.ladder.domain;

import java.util.List;

public class UsersFactory {

    private UsersFactory() {
        throw new UnsupportedOperationException();
    }

    public static Users createUsers(List<User> users) {
        return new Users(users);
    }
}
