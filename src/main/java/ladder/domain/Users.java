package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public int getUserCount() {
        return users.size();
    }

    public String getUserNames() {
        return users.stream()
                .map(user -> user.getNameAndBlank())
                .collect(Collectors.joining(" "));
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
