package ladder.domain.user;

import util.StringUtils;

import java.util.Objects;

import static util.Preconditions.checkArgument;

public class User {
    private static final int MAXIMUM_USER_NAME_LENGTH = 5;
    public static final String USER_NAME_MUST_NOT_BE_BLANK = "user name must not be blank";
    public static final String USER_NAME_LENGTH_MUST_NOT_MORE_THEN_FIVE = "user name length must not more then five";
    
    private final String name;

    private User(final String name) {
        this.name = name;
    }

    public static User of(final String userName) {
        checkArgument(StringUtils.isNotBlank(userName), USER_NAME_MUST_NOT_BE_BLANK);
        checkArgument(userName.length() <= MAXIMUM_USER_NAME_LENGTH, USER_NAME_LENGTH_MUST_NOT_MORE_THEN_FIVE);
        return new User(userName);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
