package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<User> getUsers() {
        return users;
    }

    public int size() {
        return users.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users1 = (Users) o;
        return Objects.equals(users, users1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
}
