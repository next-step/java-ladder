package nextstep.ladder.domain.user;

import java.util.List;
import java.util.stream.Collectors;

public class UserCollection {
    private final List<User> users;

    private UserCollection(List<User> users) {
        this.users = users;
    }

    public static UserCollection of(List<String> userNames) {
        List<User> users = userNames.stream()
                .map(User::new)
                .collect(Collectors.toList());
        return new UserCollection(users);
    }
}
