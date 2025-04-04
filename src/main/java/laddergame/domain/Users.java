package laddergame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    public static final String DELIMETER = ",";
    private final List<User> users;

    public Users(String nameString) {
        users = new ArrayList<>();
        List<String> names = Arrays.asList(nameString.split(DELIMETER));
        for (String name: names) {
            users.add(new User(name));
        }
    }

    public int getUserCount() {
        return users.size();
    }

    public List<Name> getUserNames() {
        return users.stream()
                .map(user -> user.getName())
                .collect(Collectors.toList());
    }
}
