package ladder.domain;

import java.util.Objects;

public class Point {

    private static final int NEXT_POSITION = 1;

    private final int position;
    private final Direction direction;

    public Point(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point createFirst(LineStrategy lineStrategy) {
        return new Point(0, new Direction(false, lineStrategy.add()));
    }

    public Point createNext(LineStrategy lineStrategy) {
        return new Point(position + NEXT_POSITION, direction.createNext(lineStrategy));
    }

    public Point createLast() {
        return new Point(position + NEXT_POSITION, direction.createLast());
    }

    public boolean hasLeftLine() {
        return direction.hasLeftLine();
    }

    public boolean hasRightLine() {
        return direction.hasRightLine();
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
        return position == point.position && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
