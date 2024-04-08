package nextstep.ladder.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(List<User> users) {
        assertNotEmpty(users);
        assertNotDuplicate(users);
        this.users = users;
    }

    private void assertNotEmpty(List<User> users) {
        String message = "[유저] 유저가 없습니다.";
        if (users == null || users.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    private void assertNotDuplicate(List<User> users) {
        String message = "[유저] 중복된 유저가 있습니다.";
        if (users.size() != Set.copyOf(users).size()) {
            throw new IllegalArgumentException(message);
        }
    }

    public List<User> getUsers() {
        return users.stream().collect(Collectors.toUnmodifiableList());
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(User::getUserName)
                .collect(Collectors.toUnmodifiableList());
    }
}
