package ladder.domain;

import java.util.Objects;

public class User {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR = "참여자 이름은 최소 " + MIN_NAME_LENGTH + "자 ~ " + MAX_NAME_LENGTH + "자까지 입력해야 합니다.";

    private final String userName;

    private User(String userName) {
        this.userName = userName;
        nameLengthValidationCheck();
    }

    private void nameLengthValidationCheck() {
        if ((userName.length() < MIN_NAME_LENGTH) || (userName.length() > MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    public static User of(String userName) {
        return new User(userName);
    }

    public String getUserName() {
        return userName;
    }

    public boolean contains(String name) {
        return userName.equals(name);
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
