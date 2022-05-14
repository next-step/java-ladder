package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final static String USER_NAME_DELIMITER = ",";

    private final List<User> users;

    public Users(String userNames) {
        this(toList(userNames));
    }

    Users(List<User> users) {
        this.users = users;
    }

    static Users of(List<String> userNames) {
        return new Users(join(userNames));
    }

    private static String join(List<String> userNames) {
        return String.join(USER_NAME_DELIMITER, userNames);
    }

    private static List<User> toList(String userNamesString) {
        return Arrays.stream(userNamesString.split(USER_NAME_DELIMITER))
                .map(User::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.users.toString();
    }
}
