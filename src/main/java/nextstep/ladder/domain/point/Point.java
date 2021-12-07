package nextstep.ladder.domain.point;

import nextstep.ladder.domain.exception.OutOfRangeIndexException;
import nextstep.ladder.domain.rule.WayRule;

import java.util.Objects;

import static nextstep.ladder.utils.Validation.checkNotNull;

public class Point {

    private static final int MIN_INDEX = 0;
    private static final int INDEX_UNIT = 1;

    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        checkArguments(index, direction);
        this.index = index;
        this.direction = direction;
    }

    private void checkArguments(int index, Direction direction) {
        checkNotNull(direction);

        if (index < MIN_INDEX) {
            throw new OutOfRangeIndexException();
        }
    }

    public static Point first(WayRule wayRule) {
        checkNotNull(wayRule);

        Direction firstDirection = Direction.first(wayRule.canCreate());
        return new Point(MIN_INDEX, firstDirection);
    }

    public Point next(WayRule wayRule) {
        checkNotNull(wayRule);
        return new Point(rightIndex(), direction.next(wayRule));
    }

    public Point last() {
        return new Point(rightIndex(), direction.last());
    }

    public int move() {
        if (direction.isLeft()) {
            return leftIndex();
        }
        if (direction.isRight()) {
            return rightIndex();
        }
        return stay();
    }

    private int leftIndex() {
        return index - INDEX_UNIT;
    }

    private int rightIndex() {
        return index + INDEX_UNIT;
    }

    public int stay() {
        return index;
    }

    public boolean existedRightWay() {
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
