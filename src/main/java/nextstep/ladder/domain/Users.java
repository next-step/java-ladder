package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private static final String NOT_FOUND_NAME_MATCH_USER_MESSAGE = "요청한 이름과 매치되는 사용자가 존재하지 않습니다.";

    private static final int START_HEIGHT = 0;
    private static final String USER_NAME_SEPARATOR = ",";

    private final List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }

    public static Users toUsers(final String userNames) {
        return new Users(toUsers(split(userNames)));
    }

    private static String[] split(final String userNames) {
        return userNames.split(USER_NAME_SEPARATOR);
    }

    private static List<User> toUsers(final String[] userNames) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < userNames.length; i++) {
            users.add(new User(userNames[i], new Position(i, START_HEIGHT)));
        }
        return users;
    }

    public int userCount() {
        return users.size();
    }

    public List<String> userNames() {
        return users.stream()
                .map(User::name)
                .collect(Collectors.toList());
    }

    public List<User> unmodifiableUsers() {
        return Collections.unmodifiableList(users);
    }

    public Position findUserResultPosition(final String userName) {
        return users.stream()
                .filter(user -> user.isMatchName(userName))
                .map(User::currentPosition)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_NAME_MATCH_USER_MESSAGE));
    }

}
