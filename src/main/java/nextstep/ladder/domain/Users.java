package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return Objects.equals(users, users1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }

    public List<User> getUsers() {
        return users;
    }

    public int countOfUsers() {
        return users.size();
    }

    public int maxUserNameLength() {
        User max = Collections.max(users);
        return max.getName().length();
    }
}
