package domain.user;

import util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Users {
    public static final Integer MARGIN = 5;

    private List<User> users;

    public Users(String name) {
        String[] names = StringUtils.toStringArrays(name);
        this.users = register(names);
    }

    private List<User> register(String[] names) {
        List<User> users = new ArrayList<>();
        for (String name : names) {
            users.add(new User(name));
        }
        return users;
    }

    public int size() {
        return users.size();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }
}
