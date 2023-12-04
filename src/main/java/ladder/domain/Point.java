package ladder.domain;

public class Point {

    private final boolean left;
    private final boolean right;

    private final PointType type;

    private Point(boolean left, boolean right, PointType type) {

        if (left && right) {
            throw new IllegalArgumentException("양방향 모두가 이동가능할 수는 없습니다.");
        }

        this.left = left;
        this.right = right;
        this.type = type;
    }

    public static Point first(boolean right) {
        return of(false, right, PointType.FIRST);
    }

    public Point last() {
        return of(this.right, false, PointType.LAST);
    }

    public Point next(boolean right) {
        return of(this.right, right, PointType.MIDDLE);
    }

    public static Point of(boolean left, boolean right) {
        return new Point(left, right, PointType.MIDDLE);
    }

    public static Point of(boolean left, boolean right, PointType pointType) {
        return new Point(left, right, pointType);
    }

    public Direction move() {
        if (left) {
            return Direction.LEFT;
        }

        if (right) {
            return Direction.RIGHT;
        }

        return Direction.DOWN;
    }

    public boolean right() {
        return right;
    }

    public boolean isLast() {
        return type == PointType.LAST;
    }

    @Override
    public String toString() {
        return move().name();
    }
}

