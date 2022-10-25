package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserNames {
    private final List<String> names;

    public UserNames(List<String> names) {
        this.names = names;
    }

    public List<User> toUsers() {
        List<User> users = new ArrayList<>();
        for (String name : names) {
            users.add(new User(name));
        }
        return users;
    }

    public final List<String> getAll() {
        return Collections.unmodifiableList(names);
    }
}
