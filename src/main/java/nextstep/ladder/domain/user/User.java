package nextstep.ladder.domain.user;

import java.util.Objects;
import nextstep.ladder.error.exception.UserNameEmptyException;
import nextstep.ladder.error.exception.UserNameSizeException;

public class User {

    private final String userName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(getUserName(), user.getUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName());
    }
}
