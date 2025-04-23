package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    public static final String INVALID_CONNECTION_ERROR = "사다리의 왼쪽과 오른쪽은 동시에 연결될 수 없습니다.";

    private final boolean left;
    private final boolean right;

    private Point(boolean left, boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public Point next(boolean nextRight) {
        return new Point(this.right, nextRight);
    }

    public Point next(ConnectionStrategy connectionStrategy) {
        // 오른쪽으로 이미 연결된 경우, 다음 Point는 무조건 왼쪽만 연결
        boolean nextRight = this.right ? false : connectionStrategy.connect();
        return next(nextRight);
    }

    public Point last() {
        return new Point(this.right, false);
    }

    private void validate(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(INVALID_CONNECTION_ERROR);
        }
    }

    public int move(int position) {
        return direction().move(position);
    }

    private Direction direction() {
        if (left) {
            return Direction.LEFT;
        }

        if (right) {
            return Direction.RIGHT;
        }

        return Direction.STAY;
    }

    public boolean isMatchWithNext(Point next) {
        return right == next.left;
    }

    public boolean isValidFirst() {
        return !left;
    }

    public boolean isValidLast() {
        return !right;
    }

    public boolean hasRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
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
