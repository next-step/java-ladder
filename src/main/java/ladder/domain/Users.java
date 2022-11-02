package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private static final int MAX_NAME_SIZE = 5;
    
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }
    
    public static Users from(List<String> names) {
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
}
