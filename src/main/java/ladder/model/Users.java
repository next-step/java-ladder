package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Users {
    private final List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }

    public static Users from(String[] input) {
        return new Users(
                Arrays.stream(input)
                        .map(User::new)
                        .collect(Collectors.toList())
        );
    }

    public User getUser(int index) {
        return users.get(index);
    }

    public int size() {
        return users.size();
    }

    public Stream<User> stream() {
        return users.stream();
    }
}
