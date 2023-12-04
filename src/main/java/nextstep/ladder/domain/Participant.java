package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.domain.lines.position.Position;

public class Participant {
    public static final String PARTICIPANT_NAME_LENGTH_EXCEPTION = "참가자의 이름은 1자에서 5자 사이여야 합니다.";
    private final String name;
    private Position position;

    public Participant(String name, Position position) {
        validateNameLength(name);
        this.name = name;
        this.position = position;
    }

    public Participant(String name, int position) {
        validateNameLength(name);
        this.name = name;
        this.position = new Position(position);
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
        return Objects.equals(name, that.name) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
