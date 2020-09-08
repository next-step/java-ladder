package nextstep.ladder.domain.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.domain.user.User.splitByUserName;

public class UserGenerator {

    public static List<User> generateUsers(String names) {
        return Arrays.stream(splitByUserName(names))
                .map(User::new)
                .collect(Collectors.toList());
    }

}
