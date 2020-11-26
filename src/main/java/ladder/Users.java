package ladder;

import util.CollectionUtil;

import java.util.List;

import static util.Preconditions.checkArgument;

public class Users {
    public static final String NUMBER_OF_USER_MUST_BE_MORE_THEN_TWO = "number of user must be more then two";
    private final List<User> users;

    private Users(final List<User> users) {
        this.users = users;
    }

    public static Users of(final List<User> userList) {
        checkArgument(CollectionUtil.isNotEmpty(userList), NUMBER_OF_USER_MUST_BE_MORE_THEN_TWO);
        checkArgument(userList.size() >= 2, NUMBER_OF_USER_MUST_BE_MORE_THEN_TWO);
        return new Users(userList);
    }

    public int size() {
        return users.size();
    }
}
