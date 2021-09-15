package step4.domain.ladder;

import java.util.Objects;
import step4.strategy.DirectionGenerateStrategy;

public class Point {

    private static final int START_INDEX = 0;

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
