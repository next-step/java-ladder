package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public int count() {
        return users.size();
    }

    public List<String> names() {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

}
