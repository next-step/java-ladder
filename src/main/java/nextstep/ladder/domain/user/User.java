package nextstep.ladder.domain.user;

import nextstep.ladder.error.exception.UserNameEmptyException;
import nextstep.ladder.error.exception.UserNameSizeException;

public class User {

    private String userName;

    public User(String userName) {
        if (userName == null || userName.isEmpty() || userName.isBlank()) {
            throw new UserNameEmptyException(userName);
        }

        if (userName.length() > 5) {
            throw new UserNameSizeException(userName);
        }
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
