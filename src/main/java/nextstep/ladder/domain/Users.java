package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    public Users (List<User> users) {
        this.users = users;
    }

    public static Users of(List<String> names) {
        return names.stream()
                .map(User::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Users::new));
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
