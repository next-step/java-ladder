package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("Point 는 양쪽이 true 일 수 없습니다.");
        }

        this.left = left;
        this.right = right;
    }

    public Point right(boolean right) {
        return new Point(this.right, right);
    }

    public boolean isRight() {
        return this.right;
    }

    public int move() {
        if (left) {
            return -1;
        }

        if (right) {
            return 1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return left == point1.left;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left);
    }

    @Override
    public String toString() {
        return "Point{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
