package step2.domain;

import java.util.Objects;

public class Point {
    private static final int FIRST_INDEX = 0;
    private static final int NEXT_INDEX = 1;
    private static final String LEFT_AND_RIGHT_NOT_TRUE = "양 쪽 모두 사다리를 그릴 수 없습니다.";

    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        if (direction.isLeft() && direction.isRight()) {
            throw new IllegalArgumentException(LEFT_AND_RIGHT_NOT_TRUE);
        }
        this.index = index;
        this.direction = direction;
    }

    public static Point first(BooleanGenerator booleanGenerator) {
        return new Point(FIRST_INDEX, Direction.first(booleanGenerator.nextBoolean()));
    }

    public Point middle(BooleanGenerator booleanGenerator) {
        return new Point(this.index + NEXT_INDEX, this.direction.middle(booleanGenerator.nextBoolean()));
    }

    public Point last() {
        return new Point(this.index + NEXT_INDEX, this.direction.last());
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
