package nextstep.ladder.entity.user;

import nextstep.ladder.common.Constants;
import nextstep.ladder.util.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Users {
    private final List<User> users;

    public Users(String userInput) {
        this.users = usersInit(userInput);
    }

    private List<User> usersInit(String userInput) {

        String[] users = StringUtil.splitCommaByString(userInput);

        return IntStream.range(0, users.length)
                .mapToObj(index -> new User(users[index], index))
                .collect(Collectors.toList());
    }

    public List<String> userNames() {
        return users.stream().map(User::name)
                .collect(Collectors.toList());
    }

    public List<User> users() {
        return Collections.unmodifiableList(users);
    }

    public int userCount() {
        return this.users.size();
    }

    public int startPosition(String userName) {
        return users.stream()
                .filter(user -> user.name().equals(userName))
                .findFirst().map(User::startPosition)
                .orElseThrow(() -> new IllegalArgumentException(Constants.USER_NOT_FOUND_MESSAGE));
    }
}
