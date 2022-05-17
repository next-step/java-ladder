package ladder.domain;

import ladder.exception.InvalidParticipantNameException;

public class Participant {

    private static final int MAX_PARTICIPANT_NAME_LENGTH = 5;
    private static final int MIN_PARTICIPANT_NAME_LENGTH = 1;
    private final String name;

    public Participant(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (hasRightLength(name)) {
            throw new InvalidParticipantNameException();
        }
    }

    private boolean hasRightLength(String name) {
        return name.length() > MAX_PARTICIPANT_NAME_LENGTH || name.length() < MIN_PARTICIPANT_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
