package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Position {

    private final Direction direction;

    public Position(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return direction == position.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
