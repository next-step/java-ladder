package laddergame.domain;

import java.util.Objects;

public class User {
    private final Name name;

    public User(String name) {
        this.name = new Name(name);
    }

    public Name getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
