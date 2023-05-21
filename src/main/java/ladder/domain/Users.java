package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    public static Users create(String[] usersArr) {
        List<User> users = Arrays.stream(usersArr)
                .map(User::create)
                .collect(Collectors.toList());

        return Users.create(users);
    }

    public static Users create(List<User> users) {
        return new Users(users);
    }

    private Users(List<User> users) {
        validateUsers(users);
        this.users = users;
    }

    private void validateUsers(List<User> users) {
        if (isEmpty(users)) {
            throw new IllegalArgumentException("Users is Empty");
        }
    }

    private boolean isEmpty(List<User> users) {
        return users == null || users.isEmpty();
    }

    public int size() {
        return users.size();
    }
}
