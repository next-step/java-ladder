package step4.domain.ladder;

import java.util.Objects;
import step4.strategy.DirectionGenerateStrategy;

public class Point {

    private static final int START_INDEX = 0;
    private static final int NEXT_INDEX_VALUE = 1;

    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    static Point from(int index, Direction direction) {
        return new Point(index, direction);
    }

    public static Point first(DirectionGenerateStrategy strategy) {
        return new Point(START_INDEX, Direction.first(strategy));
    }

    public Point next(DirectionGenerateStrategy strategy) {
        return new Point(Math.addExact(index, NEXT_INDEX_VALUE), direction.next(strategy));
    }

    public Point last() {
        return new Point(Math.addExact(index, NEXT_INDEX_VALUE), direction.last());
    }

    public int move() {
        if (direction.isNext()) {
            return Math.addExact(index, NEXT_INDEX_VALUE);
        }
        if (direction.isPrev()) {
            return Math.subtractExact(index, NEXT_INDEX_VALUE);
        }

        return index;
    }

    public boolean isNextConnect() {
        return direction.isNext();
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
        return index == point.index && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }

}
