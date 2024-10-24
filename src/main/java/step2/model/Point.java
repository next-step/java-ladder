package step2.model;

import java.util.Objects;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public int move(int point) {
        if (left) {
            return point + Direction.LEFT.getOffset();
        }
        if (right) {
            return point + Direction.RIGHT.getOffset();
        }
        return point + Direction.DOWN.getOffset();
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Point next(boolean right) {
        return new Point(this.right, right);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return this.left == point.left && this.right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.left, this.right);
    }
}
