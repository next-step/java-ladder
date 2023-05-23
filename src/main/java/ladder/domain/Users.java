package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;


    private Users(List<User> users) {
        validateUsers(users);
        this.users = users;
    }

    private void validateUsers(List<User> users) {
        if (isEmpty(users)) {
            throw new IllegalArgumentException("Users is Empty");
        }
    }

    public static Users create(List<String> userNames) {
        List<User> users = userNames.stream()
                .map(User::create)
                .collect(Collectors.toList());

        return new Users(users);
    }

    private boolean isEmpty(List<User> users) {
        return users == null || users.isEmpty();
    }

    public int size() {
        return users.size();
    }
}
