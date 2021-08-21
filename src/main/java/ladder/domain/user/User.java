package ladder.domain.user;

import ladder.exception.EmptyUserNameException;
import ladder.exception.GreaterThenMaxUserNameException;

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
}
