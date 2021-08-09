package ladder.domain;

import ladder.exception.OutOfSizeException;
import ladder.util.StringLength;
import java.util.Objects;

public class Name {
    private static final StringLength VALID_NAME_LENGTH = new StringLength(1, 5);

    private final String name;

    public Name(String name) {
        VALID_NAME_LENGTH.orThrow(name, OutOfSizeException::new);

        this.name = name;
    }


    public String toString() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}