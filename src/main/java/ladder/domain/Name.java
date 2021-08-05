package ladder.domain;

import ladder.exception.OutOfLengthException;
import ladder.util.StringLength;

import java.util.Objects;

public class Name {
    private static final StringLength VALID_NAME_LENGTH = new StringLength(1, 5);

    private final String name;

    public Name(String name) {
        VALID_NAME_LENGTH.orThrow(name, OutOfLengthException::new);

        this.name = name;
    }

    @Override
    public boolean equals(Object compareValue) {
        if (this == compareValue) return true;
        if (compareValue == null || getClass() != compareValue.getClass()) return false;
        Name name = (Name) compareValue;
        return Objects.equals(this.name, name.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String toString() {
        return name;
    }
}
