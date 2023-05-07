package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public static Users of(List<String> userNames) {
        List<User> users = userNames.stream()
                .map(User::new)
                .collect(Collectors.toList());

        return new Users(users);
    }

    public int size() {
        return this.users.size();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }
}
