package ladder.structure.connection.result;

import ladder.structure.connection.MoveStrategy;

import java.util.Objects;

import static ladder.structure.connection.result.Direction.*;

public class Point {
    private Direction direction;

    private Point(Direction direction) {
        this.direction = direction;
    }

    public static Point of(boolean leftOpened, MoveStrategy moveStrategy) {
        if (leftOpened) {
            return new Point(LEFT);
        }
        boolean movable = moveStrategy.isMovableToRight();
        if (movable) {
            return new Point(RIGHT);
        }
        return new Point(STAY);
    }

    public static Point lastOf(boolean connectedRight) {
        if (connectedRight) {
            return new Point(LEFT);
        }
        return new Point(STAY);
    }

    public int getNextIndex(int index) {
        return index + direction.getNum();
    }

    public boolean isRightOpened() {
        return direction == RIGHT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
