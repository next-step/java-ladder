package ladder.domain;

import ladder.domain.enums.MoveStatus;
import ladder.exception.PointException;

import java.util.Objects;

public class Point {
    public static final String NOT_ALLOWED_CONSECUTIVE_LINE_MESSAGE = "사다리 라인을 연속해서 만들 수 없습니다.";
    private final boolean left;
    private final boolean right;

    private Point(boolean left, boolean right) {
        if (left && right) {
            throw new PointException(NOT_ALLOWED_CONSECUTIVE_LINE_MESSAGE);
        }
        this.left = left;
        this.right = right;
    }

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public Point next(boolean right) {
        return new Point(this.right, right);
    }

    public Point last() {
        return new Point(this.right, false);
    }

    public boolean getRight() {
        return right;
    }

    public MoveStatus move() {
        if (!this.left && this.right) {
            return MoveStatus.RIGHT;
        }
        if (this.left && !this.right) {
            return MoveStatus.LEFT;
        }
        return MoveStatus.STOP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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