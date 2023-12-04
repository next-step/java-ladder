package ladder.domain;

public class Point {

    private final Direction direction;

    private Point(boolean left, boolean right) {
        this.direction = Direction.of(left, right);
    }

    public static Point first(boolean right) {
        return of(false, right);
    }

    public Point last() {
        return of(right(), false);
    }

    public Point next(boolean right) {
        if (right()) {
            return of(true, false);
        }

        return of(false, right);
    }

    public static Point of(boolean left, boolean right) {
        return new Point(left, right);
    }

    public int move(int position) {
        if (left()) {
            return position - 1;
        }

        if (right()) {
            return position + 1;
        }

        return position;
    }

    public Direction direction() {
        return direction;
    }

    public boolean left() {
        return direction == Direction.LEFT;
    }

    public boolean right() {
        return direction == Direction.RIGHT;
    }
}

