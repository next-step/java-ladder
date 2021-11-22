package nextstep.refactor_ladder.domain.value;

import nextstep.ladder.utils.Preconditions;
import nextstep.refactor_ladder.strategy.LadderStrategy;

import java.util.Objects;

public class Point {
    private static final Integer FIRST_POINT_INDEX = 0;
    private static final Integer NEXT_POINT_INDEX = 1;

    public final int index;
    public final Direction direction;

    private Point(int index, Direction direction) {
        Preconditions.checkNotNull(direction, "direction는 필수값입니다.");

        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return of(FIRST_POINT_INDEX, Direction.first(right));
    }

    public static Point of(int index, Direction direction) {
        return new Point(index, direction);
    }

    public Point next(LadderStrategy ladderStrategy) {
        return of(index + NEXT_POINT_INDEX, direction.next(ladderStrategy));
    }

    public Point last() {
        return of(index + NEXT_POINT_INDEX, direction.last());
    }

    public int move() {
        return index + direction.move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
