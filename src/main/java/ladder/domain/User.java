package ladder.domain;

import util.StringUtils;

import static util.Preconditions.checkArgument;

public class User {
    public static final String USER_NAME_MUST_NOT_BE_BLANK = "user name must not be blank";
    public static final String USER_NAME_LENGTH_MUST_NOT_MORE_THEN_FIVE = "user name length must not more then five";

    private final String name;

    private User(final String name) {
        this.name = name;
    }

    public static User of(final String userName) {
        checkArgument(StringUtils.isNotBlank(userName), USER_NAME_MUST_NOT_BE_BLANK);
        checkArgument(userName.length() <= 5, USER_NAME_LENGTH_MUST_NOT_MORE_THEN_FIVE);
        return new User(userName);
    }

    public String getName() {
        return name;
    }
}
