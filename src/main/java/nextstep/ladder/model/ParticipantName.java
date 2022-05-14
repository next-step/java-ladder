package nextstep.ladder.model;

import java.util.Objects;

public final class ParticipantName {

    private static final String EXCEPTION_MESSAGE = "참가자의 이름의 길이는 1자리에서 5자리입니다.";
    private static final String BLANK_VALUE = " ";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public ParticipantName(String value) {
        validate(value);
        this.value = value;
    }

    public void validate(String value) {
        int length = value.length();
        if (length < MIN_NAME_LENGTH || MAX_NAME_LENGTH < length) {
            throw new IndexOutOfBoundsException(EXCEPTION_MESSAGE);
        }
    }
    public long length() {
        return value.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantName that = (ParticipantName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        int repeatValue = MAX_NAME_LENGTH - value.length();
        return BLANK_VALUE.repeat(repeatValue).concat(value);
    }
}
