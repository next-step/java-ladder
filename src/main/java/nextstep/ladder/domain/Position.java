package nextstep.ladder.domain;

import java.util.Objects;

public class Position {
    private static final int ZERO = 0;

    private final int position;

    public Position(int position) {
        this.validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < ZERO) {
            throw new IllegalArgumentException("position is not negative number");
        }
    }

    public int getPosition() {
        return this.position;
    }

    public Position nextPosition() {
        return new Position(this.position + 1);
    }

    public Position prevPosition() {
        return new Position(this.position - 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (Objects.isNull(obj) || this.getClass() != obj.getClass()) {
            return false;
        }

        Position position = (Position) obj;
        return this.position == position.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.position);
    }
}
