package ladder.domain.user;

import ladder.exception.EmptyUserNameException;
import ladder.exception.GreaterThenMaxUserNameException;

import java.util.Objects;

public final class User {

    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public User(final String name) {
        validateNameNullOrEmpty(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameNullOrEmpty(final String name) {
        if (name == null || name.isEmpty()) {
            throw new EmptyUserNameException();
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new GreaterThenMaxUserNameException();
        }
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
