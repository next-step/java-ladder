package ladderrefactoring.domain.ladder;

import java.util.Objects;

public class Point {

    private final int index;
    private final boolean left;
    private final boolean right;
    private final Direction direction;

    private Point(int index, boolean left, boolean right) {
        this.index = index;
        this.left = left;
        this.right = right;
        this.direction = new Direction(left, right);
    }

    public static Point first(boolean right) {
        return new Point(0, false, right);
    }

    public static Point of(int index, boolean left, boolean right) {
        return new Point(index, left, right);
    }

    public static Point of(Point pointBefore, boolean right) {
        return new Point(pointBefore.index + 1, pointBefore.right, right);
    }

    public static Point last(Point pointBefore) {
        return new Point(pointBefore.index + 1, pointBefore.right, false);
    }

    public int move() {
        if(direction.left()) {
            return index - 1;
        }
        if(direction.right()) {
            return index + 1;
        }
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return index == point.index && left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, left, right);
    }
}
