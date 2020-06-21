package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.IntStream;
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

    public int getUserIndex(String name) {
        return IntStream
                .range(0, users.size())
                .filter(i -> users.get(i).getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User is not found"));
    }
}
