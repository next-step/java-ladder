package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }

    public static Users of(String[] userNames) {
        List<User> users = Arrays.stream(userNames)
                .map(userName -> new User(userName))
                .collect(Collectors.toList());
        return new Users(users);
    }

    public int count() {
        return this.users.size();
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserByIndex(int index) {
        return this.users.get(index);
    }
}
