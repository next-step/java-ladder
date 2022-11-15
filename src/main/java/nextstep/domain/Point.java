package nextstep.domain;

import java.util.Objects;

public class Point {
    private boolean left;
    private boolean right;

    public Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("그 방향으로 갈 수 없습니다.");
        }
        this.left = left;
        this.right = right;
    }

    public static Point init(boolean right) {
        return new Point(false, right);
    }

    public Point last() {
        return new Point(this.right, false);
    }

    public Point insert(boolean right) {
        if (this.right) {
            return new Point(true, false);
        }
        return new Point(false, right);
    }

    public Direction move() {
        if (left) {
            return Direction.LEFT;
        }
        if (right) {
            return Direction.RIGHT;
        }
        return Direction.PASS;
    }

    public boolean isPoint() {
        return left;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Point{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
