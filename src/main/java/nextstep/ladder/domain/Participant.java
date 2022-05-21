package nextstep.ladder.domain;

import nextstep.ladder.exception.IllegalParticipantNameException;

public class Participant {

    private static final int BASE_LENGTH_PARTICIPANT_NAME = 5;

    private final String name;
    private final int index;

    public Participant(int index, String name) {
        validate(name);
        this.index = index;
        this.name = name;
    }

    private void validate(String name) {
        validateNullAndEmpty(name);
        validateValueLength(name);
    }

    private void validateNullAndEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalParticipantNameException(name);
        }
    }

    private void validateValueLength(String name) {
        if (name.length() > BASE_LENGTH_PARTICIPANT_NAME) {
            throw new IllegalParticipantNameException(name);
        }
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
