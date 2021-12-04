package nextstep.ladder;

import java.util.Objects;

public class Point {

    public static final int MIN_INDEX = 0;
    private static final int FIRST_INDEX = 0;
    private static final int INDEX_UNIT = 1;

    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        checkArguments(index, direction);
        this.index = index;
        this.direction = direction;
    }

    private void checkArguments(int index, Direction direction) {
        if (index < MIN_INDEX) {
            throw new InvalidIndexException();
        }
        if (direction == null) {
            throw new RequiredArgumentException();
        }
    }

    public static Point first(WayRule wayRule) {
        return first(wayRule.canCreate());
    }

    public static Point first(boolean right) {
        return new Point(FIRST_INDEX, Direction.first(right));
    }

    public Point next(WayRule wayRule) {
        return new Point(right(), direction.next(wayRule));
    }

    public Point next(boolean nextRight) {
        return new Point(right(), direction.next(nextRight));
    }

    public Point last() {
        return new Point(right(), direction.last());
    }

    public int move() {
        if (direction.isLeft()) {
            return left();
        }
        if (direction.isRight()) {
            return right();
        }
        return stay();
    }

    private int left() {
        return index - INDEX_UNIT;
    }

    private int right() {
        return index + INDEX_UNIT;
    }

    public int stay() {
        return index;
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
