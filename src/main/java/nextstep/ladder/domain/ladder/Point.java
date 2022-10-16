package nextstep.ladder.domain.ladder;

public class Point {

    public static final int DEFAULT_POSITION = 0;
    private static final String INVALID_POSITION_EXCEPTION_MESSAGE = "위치는 0 이상이어야 합니다.";
    private static final String DIRECTION_EXCEPTION_MESSAGE = "두 방향 모두 열릴 수 없습니다.";

    private final int position;
    private final Direction direction;

    public static Point first(EnablePointStrategy strategy) {
        return new Point(DEFAULT_POSITION, false, strategy.isEnabled());
    }

    public static Point nextOf(Point prevPoint, EnablePointStrategy strategy) {
        boolean enable = strategy.isEnabled();
        int nextPosition = prevPoint.position + 1;

        if (prevPoint.hasLeft()) {
            return new Point(nextPosition, false, enable || strategy.isEnabled());
        }

        if (prevPoint.hasRight()) {
            return new Point(nextPosition, true, false);
        }

        return new Point(nextPosition, false, enable);
    }

    public static Point lastOf(Point prevPoint, EnablePointStrategy strategy) {
        Point point = nextOf(prevPoint, strategy);
        return new Point(point.position, point.hasLeft(), false);
    }

    public Point(int position, boolean left, boolean right) {
        validate(position, left, right);

        this.position = position;
        this.direction = new Direction(left, right);
    }

    private void validate(int position, boolean left, boolean right) {
        if (position < DEFAULT_POSITION) {
            throw new IllegalArgumentException(INVALID_POSITION_EXCEPTION_MESSAGE);
        }

        if (left && right) {
            throw new IllegalArgumentException(DIRECTION_EXCEPTION_MESSAGE);
        }
    }

    public int nextPosition() {
        if (hasLeft()) {
            return position - 1;
        }

        if (hasRight()) {
            return position + 1;
        }

        return position;
    }

    public boolean hasLeft() {
        return direction.isLeft();
    }

    public boolean hasRight() {
        return direction.isRight();
    }

    public boolean isOverlapping(Point other) {
        return isNext(other) && isSameDirection(other);
    }

    private boolean isNext(Point other) {
        return Math.abs(this.position - other.position) == 1;
    }

    private boolean isSameDirection(Point other) {
        return direction.equals(other.direction);
    }
}
