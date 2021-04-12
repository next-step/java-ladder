package ladder.domain;

import ladder.exception.InvalidNameSizeException;

public final class Participant {

    public static final int MAXIMUM_NAME_SIZE = 5;

    private final String name;

    private Participant(String name) {
        validateSize(name);
        this.name = name;
    }

    private final void validateSize(String name) {
        if(name.length() > MAXIMUM_NAME_SIZE) {
            throw new InvalidNameSizeException();
        }
    }

    public static final Participant of(String name) {
        return new Participant(name);
    }
}
