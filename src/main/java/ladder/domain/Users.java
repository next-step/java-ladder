package ladder.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Users implements Iterable<User> {

    private final List<User> users;

    public Users(String[] users) {
        this(Arrays.stream(users)
            .map(User::new)
            .collect(Collectors.toList()));
    }

    public Users(List<User> users) {
        this.users = users;
    }

    public int count() {
        return users.size();
    }

    public User get(int index) {
        return users.get(index);
    }

    @Override
    public Iterator<User> iterator() {
        return users.iterator();
    }
}
