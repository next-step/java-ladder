package ladder.domain.user;

import ladder.domain.LadderGameResult;
import ladder.exception.EmptyUserNameException;
import ladder.exception.GreaterThenMaxUserNameException;
import ladder.exception.NotAllowUserNameException;

import java.util.Objects;

public final class User {

    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    private User(final String name) {
        this.name = name;
    }

    public static User valueOf(final String name) {
        validateNameNullOrEmpty(name);
        validateName(name);
        return new User(name);
    }

    private static void validateNameNullOrEmpty(final String name) {
        if (name == null || name.isEmpty()) {
            throw new EmptyUserNameException();
        }
    }

    private static void validateName(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new GreaterThenMaxUserNameException();
        }

        if (name.equalsIgnoreCase(LadderGameResult.FINISH_STRING)) {
            throw new NotAllowUserNameException();
        }
    }

    @Override
    public String toString() {
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
