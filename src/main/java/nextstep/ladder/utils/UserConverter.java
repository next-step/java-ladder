package nextstep.ladder.utils;

import nextstep.ladder.domain.user.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserConverter {

    private UserConverter() {
    }

    public static List<User> convertToList(String[] users) {
        return IntStream.range(0, users.length)
                .mapToObj(operand -> User.newInstance(users[operand], operand))
                .collect(Collectors.toList());
    }
}
