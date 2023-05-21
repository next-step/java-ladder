package nextstep.ladder.domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users() {
        this.users = new ArrayList<>();
    }

    public void add(User user) {
        this.users.add(user);
    }

    @Override
    public String toString() {
        return users.stream().map(User::toString).collect(Collectors.joining(","));
    }

}
