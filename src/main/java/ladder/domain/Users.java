package ladder.domain;

import java.util.List;

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

    private boolean isEmpty(List<User> users) {
        return users == null || users.isEmpty();
    }

    public static Users create(List<User> users) {
        return new Users(users);
    }

    public List<User> users() {
        return this.users;
    }

    public int size() {
        return users.size();
    }

    public User getUserByIndex(int index) {
        return this.users.get(index);
    }
}
