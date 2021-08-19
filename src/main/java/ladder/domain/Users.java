package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Users {
    private List<User> users;

    public Users(List<String> users) {
        this.users = new ArrayList<>();

        users.stream()
             .forEach(user -> this.users.add(new User(user)));
    }

    public Users(String[] users) {
        this(Arrays.asList(users));
    }

    public Users(String users) {
        this(users.replace(" ", "").split(","));
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

}
