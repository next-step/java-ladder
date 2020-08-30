package nextstep.ladder.domain;

import nextstep.ladder.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserGenerator {

    public static List<User> generateUsers(String names) {
        return Arrays.stream(getUserName(names))
                .map(User::new)
                .collect(Collectors.toList());
    }

    public static String[] getUserName(String names) {
        return new StringUtils(names).split();
    }

}
