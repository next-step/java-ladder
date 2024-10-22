package nextstep.ladder.domain;

import java.util.Set;

public class UsersFactory {

    private UsersFactory() {
        throw new UnsupportedOperationException();
    }

    public static Users createUsers(Set<User> users) {
        return new Users(users);
    }
}
