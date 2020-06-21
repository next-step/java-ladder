package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class Users {
    private List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public int size() {
        return users.size();
    }

    public Stream<User> stream() {
        return users.stream();
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User is not found"));
    }
}
