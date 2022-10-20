package laddergame.domain;

import java.util.Objects;

public class ParticipantName {

    public static final int MAX_LENGTH = 5;

    private final String value;

    public ParticipantName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("참가자 이름은 null이거나 공백일 수 없습니다.");
        }

        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("참가자 이름은 최대 5자까자 부여할 수 있습니다.");
        }
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
        return value;
    }

}
