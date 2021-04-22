package ladder.domain.participant;

import ladder.exception.InvalidNameSizeException;

public final class Participant {

    public static final int MINIMUM_SIZE = 5;
    private final String name;

    private Participant(String name) {
        validateSize(name);
        this.name = name;
    }

    private final void validateSize(String name) {
        if (name.length() > MINIMUM_SIZE) {
            throw new InvalidNameSizeException(name);
        }
    }

    public static final Participant of(String name) {
        return new Participant(name);
    }
}
