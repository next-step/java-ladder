package ladder.domain;

import java.util.Objects;

public class Point {
    private final boolean left;
    private final boolean right;

    public static Point create(boolean left, boolean right) {
        return new Point(left, right);
    }

    public static Point createFirst(boolean right) {
        return Point.create(false, right);
    }

    public static Point createNext(boolean canMoveToLeft, boolean canMoveToRight) {
        if (canMoveToLeft) {
            return Point.create(true, false);
        }

        return Point.create(false, canMoveToRight);
    }

    public static Point createLast(boolean canMoveToRight) {
        return Point.create(canMoveToRight, false);
    }

    private Point(boolean left, boolean right) {
        validatePoint(left, right);
        this.left = left;
        this.right = right;
    }

    private void validatePoint(boolean left, boolean right) {
        if (left && right == true) {
            throw new IllegalArgumentException("가로 라인이 겹칠 수 없습니다.");
        }
    }

    public boolean canMoveToLeft() {
        return this.left;
    }

    public boolean canMoveToRight() {
        return this.right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return right == point.right && left == point.left;
    }

    @Override
    public int hashCode() {
        return Objects.hash(right, left);
    }
}
