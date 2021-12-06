package ladder.domain;

import java.util.Objects;

public class User {
    private final String name;
    private final int initPosition;

    public User(String name, int initPosition) {
        this.name = name;
        this.initPosition = initPosition;
    }

    public String name() {
        return name;
    }

    public int initPosition() {
        return initPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return initPosition == user.initPosition && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, initPosition);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
