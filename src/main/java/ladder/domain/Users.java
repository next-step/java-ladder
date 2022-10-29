package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public static Users getInstance(List<String> names) {
        List<User> users = new ArrayList<>();
        for (String name : names) {
            users.add(new User(name));
        }
        return new Users(users);   
    }
    
    public int count() {
        return users.size();
    }
}
