package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Users {
    private static final int MAX_NAME_SIZE = 5;
    
    private final List<User> users;

    public Users(final List<User> users) {
        this.users = users;
    }
    
    public static Users from(final List<String> names) {
        List<User> users = new ArrayList<>();
        for (String name: names) {
            users.add(new User(name, MAX_NAME_SIZE));
        }
        return new Users(users);
    }

    public int count() {
        return users.size();
    }

    public List<String> names() {
        List<String> names = new ArrayList<>();
        for (User user : users) {
            names.add(user.getName());
        }
        return names;
    }

    public int getMaxNameSize() {
        return MAX_NAME_SIZE;
    }

    public int getOrder(final User user) {
        for (int index = 0; index < users.size(); index++) {
            if (users.get(index).equalsByName(user)) {
                return index + 1;
            }
        }
        throw new NoSuchElementException("User's start index could not be found. name="+user.getName());
    }

    public List<User> getAll() {
        return Collections.unmodifiableList(users);
    }
}
