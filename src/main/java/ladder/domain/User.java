package ladder.domain;

import java.util.Objects;

public class User {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR = "오류:: 참여자 이름은 최소 1자 ~ 5자까지 입력해야 합니다.\n\n";

    private final String userName;

    private User(String userName) {
        this.userName = userName;
        nameLengthException();
    }

    public static User of(String userName) {
        return new User(userName);
    }

    public String getUserName() {
        return userName;
    }

    private void nameLengthException() {
        if ((userName.length() < MIN_NAME_LENGTH) || (userName.length() > MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
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
