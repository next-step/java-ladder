package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Users {
    private static final String USER_SEPARATOR = ",";

    private final List<User> users;

    public static Users of(String users) {
        return new Users(Arrays.stream(users.split(USER_SEPARATOR))
                .map(User::of)
                .collect(Collectors.toList()));
    }

    public Users(List<User> users) {
        this.users = Collections.unmodifiableList(users);
    }

    public Nodes createNodes() {
        int userCount = users.size();
        return Nodes.of(Stream.iterate(0, i -> i < userCount, i -> i + 1)
                .map(i -> Node.of(users.get(i), i))
                .collect(Collectors.toList()));
    }

    public List<User> getUsers() {
        return users;
    }

    public int getUserCount() {
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
