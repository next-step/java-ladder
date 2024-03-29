package nextstep.ladder.domain;

import nextstep.ladder.exception.ParticipantNameLengthExceedException;

public class Participant {

    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Participant(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (exceedNameLength(name)) {
            throw new ParticipantNameLengthExceedException(name);
        }
    }

    private boolean exceedNameLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    public String getName() {
        return this.name;
    }
}
