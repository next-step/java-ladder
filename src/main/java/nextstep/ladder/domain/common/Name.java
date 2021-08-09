package nextstep.ladder.domain.common;

import java.util.Objects;
import nextstep.ladder.domain.common.exception.InvalidNameException;

public class Name {

    private static final int NAME_LENGTH_MAX = 5;

    private final String name;

    private Name(final String name) {
        this.name = name;
    }

    public static Name of(final String name) {
        createValidation(name);
        return new Name(name);
    }

    private static void createValidation(final String name) {
        if (name.length() > NAME_LENGTH_MAX) {
            throw new InvalidNameException();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name)) {
            return false;
        }
        final Name name1 = (Name) o;
        return Objects.equals(getName(), name1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
