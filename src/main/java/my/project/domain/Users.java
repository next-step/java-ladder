package my.project.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    public static final User DEFAULT_USER = new User("abc", 100);
    public static final String DELIMITER = ",";

    private List<User> users;

    public Users(String users) {
        this.users = parseUsers(users);
    }

    private List<User> parseUsers(String users) {
        return Arrays.stream(users.split(DELIMITER))
                .map(User::new)
                .collect(Collectors.toList());
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(String name) {
        return users.stream()
                .filter(user -> user.matchName(name))
                .findFirst()
                .orElse(DEFAULT_USER);
    }
}
