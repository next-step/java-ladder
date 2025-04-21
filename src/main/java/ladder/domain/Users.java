package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    public Users(List<String> users) {
        this.users = List.copyOf(users).stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    public int count() {
        return users.size();
    }

    public List<User> getUsers() {
        return List.copyOf(users);
    }

    int getIndex(User targetUser) {
        if (!users.contains(targetUser)) {
            throw new IllegalArgumentException("User not found: " + targetUser.getName());
        }
        return users.indexOf(targetUser);
    }
}
