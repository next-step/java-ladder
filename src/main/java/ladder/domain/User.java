package ladder.domain;

import java.util.Objects;

public class User {
    private final UserName name;

    public User(String name) {
        this.name = new UserName(name);
    }

    public boolean isSameName(UserName userName) {
        return this.name.equals(userName);
    }

    public UserName getName() {
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
