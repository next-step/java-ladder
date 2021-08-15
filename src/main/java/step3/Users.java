package step3;

import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    public Users(List<String> users) {
        this.users = createUsers(users);
    }

    private List<User> createUsers(List<String> users) {
        return users.stream().map(User::new).collect(Collectors.toList());
    }

    public int numberOf() {
        return users.size();
    }

    public List<String> usernames() {
        return users.stream()
                .map(User::toOutputString)
                .collect(Collectors.toList());
    }
}
