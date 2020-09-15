package nextstep.ladder.domain;

import nextstep.ladder.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.constant.ExceptionMessage.INVALID_JOIN_USERS_MINIMIM_SIZE;
import static nextstep.ladder.constant.ExceptionMessage.NOT_EXIST_USER_NAME;

public class Users {

    private static final int MINIMUM_JOIN_USERS = 2;

    private List<User> users;

    private Users(List<User> users) {
        this.users = users;

        if (users.size() < MINIMUM_JOIN_USERS) {
            throw new IllegalArgumentException(INVALID_JOIN_USERS_MINIMIM_SIZE);
        }
    }


    public static Users create(String users) {
        String[] splitUsers = StringUtils.split(users);

        List<User> userCollections = Arrays.stream(splitUsers).map(User::newInstance).collect(Collectors.toList());

        return new Users(userCollections);
    }

    public int size() {
        return users.size();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public User getUsers(String userName) {
        return users.stream()
                .filter(user -> user.getUserName().equals(userName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_USER_NAME));
    }

    public int userIndex(String userName) {
        User user = User.newInstance(userName);
        return users.indexOf(user);
    }
}
