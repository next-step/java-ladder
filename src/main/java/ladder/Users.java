package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Users {
    private static final String USER_SEPARATOR = ",";
    private final List<User> users;

    public static Users of(String users) {
        return new Users(Arrays.stream(users.split(USER_SEPARATOR))
                .map(User::new)
                .collect(Collectors.toList()));
    }

    public Users(List<User> users) {
        this.users = users;
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
