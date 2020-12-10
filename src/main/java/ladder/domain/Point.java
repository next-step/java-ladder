package ladder.domain;

import java.util.Objects;

public final class Point {

    private final Direction direction;

    public Point(Direction direction){
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
