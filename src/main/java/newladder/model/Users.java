package newladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Users {
    private static final int NOT_FOUND_NAME = -1;
    private final List<User> users = new ArrayList<>();

    public Users(String[] userNames) {
        for (String name : userNames) {
            containsUser(name);
            this.users.add(new User(name));
        }
    }

    public List<User> usersInfo() {
        return this.users;
    }

    public void containsUser(String name) {
        if (users.stream().anyMatch(user -> user.compareName(name))) {
            throw new IllegalArgumentException();
        }
    }

    public int userIndex(String name) {
        return users.indexOf(new User(name));
    }


}
