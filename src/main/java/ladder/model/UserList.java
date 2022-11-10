package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public int size() {
        return userList.size();
    }

    public Stream<User> stream() {
        return userList.stream();
    }
}
