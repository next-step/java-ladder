package nextstep.ladder.dto;

import java.util.Objects;

public class Participant {
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        validateNameLength(name);

        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5자만 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
