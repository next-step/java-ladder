package nextstep.ladder.domain;

import java.util.Objects;

public class LadderGameUser {
    private static final int USER_NAME_LENGTH_LIMIT = 5;
    private final String userName;

    public LadderGameUser(final String userName) {
        validate(userName);
        this.userName = userName;
    }

    private void validate(final String userName) {
        int userNameSize = userName.length();
        if (userNameSize > USER_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(String.format("유저이름은 5자를 넘길 수 없습니다. 현재글자수: %d", userNameSize));
        }
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGameUser that = (LadderGameUser) o;
        return Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    @Override
    public String toString() {
        return userName;
    }
}
