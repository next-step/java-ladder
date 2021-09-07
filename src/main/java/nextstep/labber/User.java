package nextstep.labber;

import java.util.Objects;

public class User {
    public static final int NAME_SPACE_SIZE = 5;

    private final String name;

    public User(String name) {
        if (name.length() > NAME_SPACE_SIZE) {
            throw new IllegalArgumentException("The name cannot exceed five characters.");
        }
        this.name = name;
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

    @Override
    public String toString() {
        return name;
    }
}
