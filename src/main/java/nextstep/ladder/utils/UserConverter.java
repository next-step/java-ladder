package nextstep.ladder.utils;

import nextstep.ladder.domain.game.Order;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.view.InputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class UserConverter {

    private UserConverter() {
    }

    public static List<User> convertToList(String[] users) {
        return IntStream.range(0, users.length)
                .mapToObj(operand -> User.newInstance(users[operand], Order.from(operand)))
                .collect(Collectors.toList());
    }

    public static List<User> convertToListFromInput(String input, List<User> users) {
        if (input.equalsIgnoreCase(InputView.ALL)) {
            return users;
        }
        return IntStream.range(0, users.size())
                .mapToObj(users::get)
                .filter(user -> user.getName().equals(input))
                .collect(Collectors.toList());
    }
}
