package nextstep.ladder.domain;

import java.util.Objects;

public class ParticipantName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public ParticipantName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 null이거나 공백일 수 없습니다: " + name);
        }

        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 5를 초과할 수 없습니다: " + name);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticipantName)) return false;
        ParticipantName that = (ParticipantName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
