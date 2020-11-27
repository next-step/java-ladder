package ladder.domain.point;

import java.util.Objects;
import ladder.domain.Position;
import ladder.domain.direction.Direction;

public class Point {

    private final Position position;
    private final Direction direction;

    public Point(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position goNextPoint() {
        return direction.getNextPosition(position);
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isRightDirection() {
        return direction == Direction.RIGHT;
    }

    public boolean isLeftDirection() {
        return direction == Direction.LEFT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return Objects.equals(position, point.position) &&
            direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
