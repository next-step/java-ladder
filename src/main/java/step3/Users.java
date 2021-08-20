package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Users {
    private final List<User> users;

    public Users(List<String> usernames) {
        this.users = createUsers(usernames);
    }

    private List<User> createUsers(List<String> usernames) {
        return IntStream.range(0, usernames.size())
                .mapToObj(i -> new User(usernames.get(i), new Position(i)))
                .collect(Collectors.toList());
    }

    public int numberOf() {
        return users.size();
    }

    public List<User> findUsersByUsername(String username) {
        return users.stream()
                .filter(u -> u.isMe(username) || username.equals("all"))
                .collect(Collectors.toList());
    }

    public List<String> usernames() {
        return users.stream()
                .map(User::toOutputString)
                .collect(Collectors.toList());
    }
}
