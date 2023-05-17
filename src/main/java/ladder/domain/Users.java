package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(String[] users) {
        this.users = Arrays.stream(users)
            .map(User::new)
            .collect(Collectors.toList());
    }

    public int count() {
        return users.size();
    }

}
