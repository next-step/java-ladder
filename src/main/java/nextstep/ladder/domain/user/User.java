package nextstep.ladder.domain.user;

import nextstep.ladder.error.exception.UserNameEmptyException;

public class User {

    private String userName;

    public User(String userName) {
        if (userName == null || userName.isEmpty() || userName.isBlank()) {
            throw new UserNameEmptyException(userName);
        }
        this.userName = userName;
    }

    @Override
    public String toString() {
        return String.format("%6s", userName);
    }
}
