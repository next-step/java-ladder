package nextstep.ladder.domain;

import java.util.Objects;

import static nextstep.ladder.constant.ExceptionMessage.INVALID_USER_NAME_LENGTH_UNDER_FIVE;

public class User {

    private static final int MAXIMUM_USER_NAME_LENGTH = 5;

    private String userName;

    private User(String userName) {
        this.userName = userName;

        if (userName.length() > MAXIMUM_USER_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_USER_NAME_LENGTH_UNDER_FIVE);
        }
    }

    public static User newInstance(String name) {
        return new User(name.trim());
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
