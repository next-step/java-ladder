package nextstep.ladder.domain;

import java.util.Objects;

import static nextstep.ladder.constant.ExceptionMessage.INVALID_USER_NAME_LENGTH_UNDER_FIVE;

public class User {

    private static final int MAXIMUM_USER_NAME_LENGTH = 5;

    private String userName;
    private int position;

    private User(String userName, int position) {
        this.userName = userName;
        this.position = position;

        if (userName.length() > MAXIMUM_USER_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_USER_NAME_LENGTH_UNDER_FIVE);
        }
    }

    public static User newInstance(String name, int position) {
        return new User(name.trim(), position);
    }

    public String getUserName() {
        return userName;
    }

    public int getPosition() {
        return position;
    }

    public void updateLastPosition(int position) {
        this.position = position;
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
