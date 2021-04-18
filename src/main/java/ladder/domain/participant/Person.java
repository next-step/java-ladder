package ladder.domain.participant;

import ladder.exception.InvalidIdentifierNameException;
import ladder.exception.InvalidNameSizeException;

import java.util.Objects;

public final class Person {

    private static final String INVALID_IDENTIFIER = "all";
    private static final int MAXIMUM_NAME_SIZE = 5;

    private final String name;

    public static final Person of(String name) {
        return new Person(name);
    }

    private Person(String name) {
        validateSize(name);
        validateInvalidIdentifier(name);
        this.name = name;
    }

    private final void validateInvalidIdentifier(String name) {
        if (name.equals(INVALID_IDENTIFIER)) {
            throw new InvalidIdentifierNameException(name);
        }
    }

    private final void validateSize(String name) {
        if (name.length() > MAXIMUM_NAME_SIZE) {
            throw new InvalidNameSizeException();
        }
    }

    public final String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
