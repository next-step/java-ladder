package ladder.domain;

import java.util.Objects;

public class User {
    private final String name;

    public User(String name) {
        verifyUserName(name);
        this.name = name;
    }

    private void verifyUserName(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
