package ladder.domain;

import java.util.Objects;

public final class Point {

    private static final int START_INDEX = 0;
    private static final int INDEX_STEP = 1;

    private final int index;

    private final Direction direction;

    public Point(int index, Direction direction){
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right){
        return new Point(START_INDEX, Direction.first(right));
    }

    public Point next() {
        return new Point(index + INDEX_STEP , direction.next());
    }

    public Point next(boolean right) {
        return new Point(index + INDEX_STEP , direction.next(right));
    }

    public Point last() {
        return new Point(index + INDEX_STEP, direction.last());
    }

    public int move() {
        return index + direction.moveIndex();
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }



}
