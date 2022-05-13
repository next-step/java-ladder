package nextstep.domain;

import java.util.Collections;
import java.util.List;

public class Users {
    private static final int MIN_USER_SIZE = 2;
    private final List<User> users;
    public Users(List<User> users) {
        validate(users);
        this.users = users;
    }

    private void validate(List<User> users) {
        if(users.size() < MIN_USER_SIZE) {
            throw new IllegalArgumentException("유저 수는 최소 2명 이상이여야 합니다.");
        }
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public int getUserSize() {
        return users.size();
    }
}
