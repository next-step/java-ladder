package ladder.model;

import java.util.Objects;

public class Point {

    private static final int FIRST_POSITION = 0;

    private final int position;
    private final Direction direction;

    public Point(int position, Direction direction) {
        validate(position);
        this.position = position;
        this.direction = direction;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 음수일 수 없습니다.");
        }
    }

    public int move() {
        if (direction.isRight()) {
            return position + 1;
        }
        if (direction.isLeft()) {
            return position - 1;
        }
        return position;
    }

    public static Point first(boolean nextDirection) {
        return new Point(FIRST_POSITION, Direction.first(nextDirection));
    }

    public Point next(boolean nextDirection) {
        return new Point(position + 1, direction.next(nextDirection));
    }

    public Point last() {
        return new Point(position + 1, direction.last());
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
