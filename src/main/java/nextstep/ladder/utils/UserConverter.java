package nextstep.ladder.utils;

import nextstep.ladder.domain.user.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    private UserConverter() {
    }

    public static List<User> convertToList(String[] users) {
        return Arrays.stream(users)
                .map(String::trim)
                .map(User::newInstance)
                .collect(Collectors.toList());
    }
}
