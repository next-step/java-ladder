package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Position {

    private final int position;
    private final Direction direction;

    public Position(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position &&
                Objects.equals(direction, position1.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
