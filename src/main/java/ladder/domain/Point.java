package ladder.domain;

import ladder.exception.InvalidPointException;
import ladder.utils.RandomBooleanGenerator;

import java.util.Objects;

public class Point {
    private final boolean left;
    private final boolean current;

    public static Point first(boolean current) {
        return new Point(false, current);
    }
    public static Point first() {
        boolean nextRandom = RandomBooleanGenerator.execute();

        return new Point(false, nextRandom);
    }

    private Point(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left && current == point.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }

    public Direction movedDirection() {
        if (left == false && current == true) {
            return Direction.RIGHT;
        }
        if (left == true && current == false) {
            return Direction.LEFT;
        }

        return Direction.PASS;
    }

    public Point next(boolean current) {
        if(this.current && current){
            throw new InvalidPointException();
        }
        return new Point(this.current, current);
    }

    public Point next() {
        boolean nextRandom = RandomBooleanGenerator.execute();

        if(this.current == true){
            nextRandom = false;
        }

        return new Point(this.current, nextRandom);
    }

    public Point last() {
        return new Point(this.current, false);
    }
}
