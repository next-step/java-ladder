package ladder.domain.participant;

import ladder.exception.InvalidIdentifierNameException;
import ladder.exception.InvalidNameSizeException;

import java.util.Objects;

public final class Participant {

    private static final String INVALID_IDENTIFIER = "all";
    private static final int MINIMUM_SIZE = 5;

    private final String name;

    public static final Participant of(final String name) {
        return new Participant(name);
    }

    private Participant(final String name) {
        validateSize(name);
        validateInvalidIdentifier(name);
        this.name = name;
    }

    private final void validateSize(final String name) {
        if (name.length() > MINIMUM_SIZE) {
            throw new InvalidNameSizeException(name);
        }
    }

    private final void validateInvalidIdentifier(final String name) {
        if (name.equals(INVALID_IDENTIFIER)) {
            throw new InvalidIdentifierNameException(name);
        }
    }

    public final String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
