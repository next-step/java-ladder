package nextstep.ladder.domain;

import nextstep.ladder.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.constant.ExceptionMessage.INVALID_JOIN_USERS_MINIMIM_SIZE;

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

        List<User> userCollections = IntStream.range(0, splitUsers.length)
                .mapToObj(index -> User.newInstance(splitUsers[index],index))
                .collect(Collectors.toList());

        return new Users(userCollections);
    }

    public int size() {
        return users.size();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }
}
