package nextstep.ladder.domain.user;

import java.util.Objects;

public class User {

    private final String userName;

    private User(String userName) {
        this.userName = userName;
    }

    public static User newInstance(String userName) {
        return new User(userName);
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
