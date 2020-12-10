package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    public Users (List<User> users) {
        this.users = users;
    }

    public static Users of(List<String> names) {
        List<User> users = names.stream()
                .map(User::new)
                .collect(Collectors.toList());
        return new Users(users);
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public int getSize() {
        return users.size();
    }
}
