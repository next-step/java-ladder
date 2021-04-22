package ladder.domain.participant;

import ladder.exception.InvalidIdentifierNameException;
import ladder.exception.InvalidNameSizeException;

public final class Participant {

    private static final int MINIMUM_SIZE = 5;
    public static final String INVALID_IDENTIFIER = "all";

    private final String name;

    public static final Participant of(String name) {
        return new Participant(name);
    }

    private Participant(String name) {
        validateSize(name);
        validateInvalidIdentifier(name);
        this.name = name;
    }

    private final void validateSize(String name) {
        if (name.length() > MINIMUM_SIZE) {
            throw new InvalidNameSizeException(name);
        }
    }

    private final void validateInvalidIdentifier(String name) {
        if (name.equals(INVALID_IDENTIFIER)) {
            throw new InvalidIdentifierNameException(name);
        }
    }

}
