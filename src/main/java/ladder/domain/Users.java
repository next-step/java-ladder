package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private final List<User> users;

    public Users(final List<User> users) {
        this.users = validate(users);
    }

    public List<User> validate(final List<User> users) {
        if (users.isEmpty()) {
            throw new IllegalArgumentException("빈 값이 될 수 없습니다.");
        }
        return new ArrayList<>(users);
    }


}
