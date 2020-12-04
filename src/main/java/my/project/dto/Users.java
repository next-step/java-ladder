package my.project.dto;

import my.project.dto.User;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Users {
    public static final User DEFAULT_USER = new User("codesquad", 100);
    public static final String DELIMITER = ",";
    public static final String INPUT_PATTERN = "^([A-z0-9,]*)$";
    public static final String INPUT_USERS_ALERT = "사용자 입력을 확인해주십시요.";

    private List<User> users;

    public Users(String users) {
        this.users = parseUsers(users);
    }

    private List<User> parseUsers(String users) {
        validate(users);
        return Arrays.stream(users.split(DELIMITER))
                .map(User::new)
                .collect(Collectors.toList());
    }

    private void validate(String users) {
        if (!Pattern.matches(INPUT_PATTERN, users)) {
            throw new IllegalArgumentException(INPUT_USERS_ALERT);
        }
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
