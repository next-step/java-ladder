package nextstep.ladder.domain.factory;

import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsersFactory {
    private static final String SPLIT_DELIMITER = ",";

    private UsersFactory() {
    }

    public static Users newInstance(String userNames) {
        return new Users(toUserList(userNames));
    }

    private static List<User> toUserList(String userNames) {
        return Arrays.stream(split(userNames))
                .map(User::new)
                .collect(Collectors.toList());
    }

    private static String[] split(String userNames) {
        return userNames.split(SPLIT_DELIMITER);
    }
}
