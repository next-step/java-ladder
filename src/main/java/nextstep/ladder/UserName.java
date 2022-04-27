package nextstep.ladder;

import java.util.Objects;

public class UserName {

    private static final int MAXIMUM_USER_NAME_LENGTH = 5;
    private String userName;

    public UserName(String userName) {
        if (isEmptyOrNull(userName)) {
            throw new IllegalArgumentException("사용자의 이름은 공백일 수 없습니다.");
        }
        if (isInvalidUserName(userName)) {
            throw new IllegalArgumentException("사용자의 이름은 최대 5글자입니다.");
        }
        this.userName = userName;
    }

    private boolean isEmptyOrNull(String userName) {
        return userName == null || userName.isEmpty();
    }

    private boolean isInvalidUserName(String userName) {
        return userName.length() > MAXIMUM_USER_NAME_LENGTH;
    }

    @Override
    public String toString() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName1 = (UserName) o;
        return Objects.equals(userName, userName1.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
