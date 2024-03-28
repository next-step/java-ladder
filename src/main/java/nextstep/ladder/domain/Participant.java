package nextstep.ladder.domain;

import nextstep.ladder.exception.ParticipantNameLengthExceedException;

public class Participant {
    private final String name;

    public Participant(String name, int nameMaxLength) {
        validateNameLength(name, nameMaxLength);
        this.name = name;
    }

    private void validateNameLength(String name, int nameMaxLength) {
        if (exceedNameLength(name, nameMaxLength)) {
            throw new ParticipantNameLengthExceedException(name);
        }
    }

    private boolean exceedNameLength(String name, int nameMaxLength) {
        return name.length() > nameMaxLength;
    }

    public String getName() {
        return this.name;
    }
}
