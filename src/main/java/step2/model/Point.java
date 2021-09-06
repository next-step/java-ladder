package step2.model;

import java.util.Objects;

public class Point {
    private final Direction direction;

    public Point(boolean left, boolean current) {
        this.direction = Direction.findDirection(left, current);
    }


    public boolean getCurrent() {
        return direction.getCurrent();
    }

    public int changeIndex(int index) {
        return index + direction.getMove();
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
