package step2.domain;

import java.util.Objects;

public class Point {
    private static final int NEXT_INDEX = 1;
    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        if (direction.isLeft() && direction.isRight()) {
            throw new IllegalArgumentException("양 쪽으로 갈 수 없습니다.");
        }
        this.index = index;
        this.direction = direction;
    }

    public static Point first(int index, BooleanGenerator booleanGenerator) {
        return new Point(index, Direction.first(booleanGenerator));
    }

    public static Point middle(Point point, BooleanGenerator booleanGenerator) {
        return new Point(point.index + NEXT_INDEX, Direction.middle(point.direction.isRight(), booleanGenerator));
    }

    public static Point last(Point point) {
        return new Point(point.index + NEXT_INDEX, Direction.last(point.direction.isRight()));
    }

    public int move() {
        if (direction.isLeft()) {
            return index - 1;
        }
        if (direction.isRight()) {
            return index + 1;
        }
        return index;
    }

    public boolean hasLine() {
        return direction.isRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }
}
