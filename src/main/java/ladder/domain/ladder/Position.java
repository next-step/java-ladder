package ladder.domain.ladder;

import ladder.exception.ErrorMessage;

import java.util.Objects;

public class Position {

    static final int ONE_STEP_POSITION = 1;
    static final int MIN_POSITION = 0;

    private final int position;

    private Position(final int position) {
        validatePosition(position);
        this.position = position;
    }

    public static Position of(final int position) {
        return new Position(position);
    }

    private void validatePosition(final int position) {
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException(ErrorMessage.REQUIRED_MIN_POSITION);
        }
    }

    public Position moveLeft() {
        return Position.of(position - ONE_STEP_POSITION);
    }

    public Position moveRight() {
        return Position.of(position + ONE_STEP_POSITION);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
