package ladder.domain;

import java.util.Objects;

public class User {
    private UserName userName;

    public User(String userName) {
        this.userName = new UserName(userName);
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
