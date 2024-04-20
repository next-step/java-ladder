package nextstep.ladder.domain.user;

import java.util.Objects;

public class User {

    private final UserName name;

    private User(UserName name) {
        this.name = name;
    }

    public static User of(String name) {
        return new User(UserName.of(name));
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
