package nextstep.ladder.domain;

import java.util.Objects;

public class Participant {
    public static final String PARTICIPANT_NAME_LENGTH_EXCEPTION = "참가자의 이름은 1자에서 5자 사이여야 합니다.";
    private final String name;
    private int position;

    public Participant(String name, int position) {
        validateNameLength(name);
        this.name = name;
        this.position = position;
    }

    public Participant(String name) {
        this(name, 0);
    }

    private void validateNameLength(String name) {
        if (outOfRange(name)) {
            throw new IllegalStateException(PARTICIPANT_NAME_LENGTH_EXCEPTION);
        }
    }

    private boolean outOfRange(String name) {
        return name.isEmpty() || name.isBlank() || name.length() > 5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant that = (Participant) o;
        return position == that.position && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
