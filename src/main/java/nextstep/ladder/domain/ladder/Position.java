package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Position {

    private final int position;
    private final Height height;
    private final Direction direction;

    public Position(int position, Height height, Direction direction) {
        this.position = position;
        this.height = height;
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
                Objects.equals(height, position1.height) &&
                Objects.equals(direction, position1.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, height, direction);
    }
}
