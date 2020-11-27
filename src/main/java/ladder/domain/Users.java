package ladder.domain;

import util.CollectionUtil;

import java.util.List;
import java.util.stream.Collectors;

import static util.Preconditions.checkArgument;

public class Users {
    private static final int MINIMUM_USER_COUNT = 2;
    public static final String NUMBER_OF_USER_MUST_BE_MORE_THEN_TWO = "number of user must be more then two";
    private final List<User> users;

    private Users(final List<User> users) {
        this.users = users;
    }

    public static Users of(final List<User> userList) {
        checkArgument(CollectionUtil.isNotEmpty(userList), NUMBER_OF_USER_MUST_BE_MORE_THEN_TWO);
        checkArgument(userList.size() >= MINIMUM_USER_COUNT, NUMBER_OF_USER_MUST_BE_MORE_THEN_TWO);
        return new Users(userList);
    }

    public int size() {
        return users.size();
    }

    public List<String> getNames() {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
