package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserList {
    private static final String DELIMITER = ",";
    private final List<User> userList;

    private UserList(List<User> userList) {
        this.userList = userList;
    }

    public static UserList parse(String input) {
        return new UserList(
                Arrays.stream(input.split(DELIMITER))
                        .map(User::new)
                        .collect(Collectors.toList())
        );
    }

    public User getUser(int index) {
        return userList.get(index);
    }
}
