package nextstep.ladder.model;

import java.util.Objects;

public final class Participant {

    private static final String PARTICIPANT_NAME_NULL_EXCEPTION_MESSAGE = "참가자의 이름은 null이거나 공백일 수 없습니다.";
    private static final String PARTICIPANT_NAME_LENGTH_EXCEPTION_MESSAGE = "참가자의 이름의 길이는 1자리에서 5자리입니다.";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Participant(String name) {
        validate(name);
        this.name = name;
    }


    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(PARTICIPANT_NAME_NULL_EXCEPTION_MESSAGE);
        }
        validateNameLengthCheck(name);
    }

    private void validateNameLengthCheck(String name) {
        int length = name.length();
        if (length < MIN_NAME_LENGTH || MAX_NAME_LENGTH < length) {
            throw new IllegalArgumentException(PARTICIPANT_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
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
