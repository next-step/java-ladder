package step1.domain;

import java.util.Objects;

public class UserName {

    private static final int MAX_NAME_LENGTH = 5;
    private final String userName;

    public UserName(String userName) {
        validateUserName(userName);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    private void validateUserName(String userName) {
        if (userName == null || userName.isEmpty() || userName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 유저 이름입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserName)) {
            return false;
        }

        UserName userName1 = (UserName) o;

        return Objects.equals(userName, userName1.userName);
    }

    @Override
    public int hashCode() {
        return userName != null ? userName.hashCode() : 0;
    }
}
