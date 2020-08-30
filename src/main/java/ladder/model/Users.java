package ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public static Users of(List<String> userNames) {
        List<User> userList = userNames.stream()
                                    .map(User::new)
                                    .collect(Collectors.toList());
        return new Users(userList);
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public int getSize() {
        return users.size();
    }

}
