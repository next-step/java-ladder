package ladder.domain;

import ladder.exception.NotFoundUserException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Users {
    private final List<User> users;

    public Users(String[] usersName) {
        List<User> users = new ArrayList<>();
        Arrays.stream(usersName)
                .map(User::new)
                .forEach(users::add);
        this.users = users;
    }

    public int usersCount() {
        return users.size();
    }

    public User getUserToPosition(int position) {
        return users.get(position);
    }

    public User getUserToName(String name) {
        User findUser = User.valueOf(name);
        return users.stream()
                .filter(user -> user.equals(findUser))
                .findFirst()
                .orElseThrow(() -> new NotFoundUserException(name));
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }
}
