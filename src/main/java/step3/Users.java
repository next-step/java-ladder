package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public int numberOf() {
        return users.size();
    }

    public List<User> findUsersByUsername(String username) {
        return users.stream()
                .filter(u -> u.isMe(username) || username.equals("all"))
                .collect(Collectors.toList());
    }

    public List<String> getUsernames() {
        return users.stream()
                .map(User::toOutputString)
                .collect(Collectors.toList());
    }
}
