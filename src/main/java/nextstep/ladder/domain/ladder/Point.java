package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Point {

    public static final int DEFAULT_POSITION = 0;
    private static final String INVALID_POSITION_EXCEPTION_MESSAGE = "위치는 0 이상이어야 합니다.";
    private static final String DIRECTION_EXCEPTION_MESSAGE = "두 방향 모두 열릴 수 없습니다.";

    private final int position;
    private final boolean left;
    private final boolean right;

    public static Point first(EnablePointStrategy strategy) {
        return new Point(DEFAULT_POSITION, false, strategy.isEnable());
    }

    public static Point nextOf(Point prevPoint, EnablePointStrategy strategy) {
        boolean enable = strategy.isEnable();
        int nextPosition = prevPoint.position + 1;

        if (prevPoint.hasLeft()) {
            return of(nextPosition, false, enable);
        }

        if (prevPoint.hasRight()) {
            return of(nextPosition, true, false);
        }

        return of(nextPosition, strategy);
    }

    public static Point lastOf(Point prevPoint, EnablePointStrategy strategy) {
        Point point = nextOf(prevPoint, strategy);
        return of(point.position, point.hasLeft(), false);
    }

    public static Point of(int position, EnablePointStrategy strategy) {
        boolean left = strategy.isEnable();
        boolean right = strategy.isEnable();

        if (isAnyOpen(left, right)) {
            left = strategy.isEnable();
            right = !left;
        }

        return new Point(position, left, right);
    }

    private static boolean isAnyOpen(boolean left, boolean right) {
        return left && right;
    }

    public static Point of(int position, boolean left, boolean right) {
        return new Point(position, left, right);
    }

    public Point(int position, boolean left, boolean right) {
        validate(position, left, right);

        this.position = position;
        this.left = left;
        this.right = right;
    }

    private void validate(int position, boolean left, boolean right) {
        if (position < DEFAULT_POSITION) {
            throw new IllegalArgumentException(INVALID_POSITION_EXCEPTION_MESSAGE);
        }

        if (left && right) {
            throw new IllegalArgumentException(DIRECTION_EXCEPTION_MESSAGE);
        }
    }

    public int position() {
        return position;
    }

    public boolean hasLeft() {
        return left;
    }

    public boolean hasRight() {
        return right;
    }

    public boolean isOverlap(Point other) {
        return isNext(other) && isSameDirection(other);
    }

    private boolean isNext(Point other) {
        return Math.abs(this.position - other.position) == 1;
    }

    private boolean isSameDirection(Point other) {
        return (this.left && other.left) || (this.right && other.right);
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
        return position == point.position && left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, left, right);
    }
}
