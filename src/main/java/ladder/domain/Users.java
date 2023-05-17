package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private static final String DELIMITER = ",";
    private final List<User> users;

    public Users(String input) {
        users = splitUsers(input);
    }

    public List<User> unmodifiableUsers() {
        return Collections.unmodifiableList(users);
    }

    public int getUsersSize() {
        return users.size();
    }

    private List<User> splitUsers(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(User::new)
                .collect(Collectors.toList());
    }

}
