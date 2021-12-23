package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Users {

    private final List<User> users;

    private Users(List<User> users) {
        this.users = new ArrayList<>(users);
    }

    public static Users from(List<String> userNames) {
        return new Users(users(userNames));
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public int size() {
        return users.size();
    }

    private static List<User> users(List<String> userNames) {
        return userNames.stream()
                .map(UserName::new)
                .map(User::new)
                .collect(Collectors.toList());
    }
}
