package nextstep.ladder.domain;

import java.util.Objects;

public class ParticipantName {

    public static final int NAME_WIDTH = 5;

    private final String value;

    public ParticipantName(String value) {
        this.value = value;
        validate();
    }

    private void validate() {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("참여자의 이름은 null이거나 빈 문자열일 수 없습니다.");
        }

        if (value.length() > NAME_WIDTH) {
            throw new IllegalArgumentException("참여자의 이름은 5자 이하이어야 합니다.");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantName that = (ParticipantName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
