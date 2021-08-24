package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }

    public static Users create(String users) {
        return new Users(
                Arrays.stream(users.split(","))
                        .map(User::createWithName)
                        .collect(Collectors.toList())
        );
    }

    public static Users create(User... users) {
        return new Users(new ArrayList<>(Arrays.asList(users)));
    }

    public int size() {
        return users.size();
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
