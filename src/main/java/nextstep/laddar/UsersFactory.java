package nextstep.laddar;

import java.util.List;
import java.util.stream.Collectors;

public class UsersFactory {
    public static Users createUsers(List<String> usernames) {
        List<User> users = usernames.stream()
                .map(User::new)
                .collect(Collectors.toList());
        return new Users(users);
    }

}
