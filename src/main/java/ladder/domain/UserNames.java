package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserNames {
    private static final Pattern NAMES = Pattern.compile("[,]");
    private final String names;

    public UserNames(final String names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        this.names = names;
    }

    public List<User> toUsers() {
        List<User> users = new ArrayList<>();
        for (String name : NAMES.split(names)) {
            users.add(new User(name));
        }
        return users;
    }
}
