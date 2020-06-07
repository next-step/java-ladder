package nextstep.ladder.domain.user;

import java.util.Objects;

public class User {

    private final String name;

    private User(String name) {
        this.name = name;
    }

    public static User newInstance(String userName) {
        return new User(userName);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
