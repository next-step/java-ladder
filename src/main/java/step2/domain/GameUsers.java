package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameUsers {
    List<User> users;

    public GameUsers(List<String> userNames) {
        this.users = userNames.stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    public int getUserCount() {
        return users.size();
    }

    public List<User> getUsers() {
        return users;
    }

}
