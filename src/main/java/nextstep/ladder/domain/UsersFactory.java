package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsersFactory {
    public static final String USER_NAME_DELIMITER = ",";

    public static Users create(String userNames) {
        return new Users(toList(userNames));
    }

    private static List<User> toList(String userNames) {
        return Arrays.stream(userNames.split(USER_NAME_DELIMITER))
                .map(User::new)
                .collect(Collectors.toList());
    }
}
