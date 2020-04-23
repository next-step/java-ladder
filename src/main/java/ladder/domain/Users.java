package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Users {
    private final List<User> users;

    public static Users of(final String userNames, final String separator) {
        return new Users(Stream.of(userNames.split(separator))
                .map(User::new)
                .collect(Collectors.toList()));
    }

    public Users(final List<User> users) {
        this.users = new ArrayList<>(users);
    }

    public int size() {
        return users.size();
    }

    public User getUser(final Position userPosition) {
        return users.get(userPosition.toInt());
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }
}
