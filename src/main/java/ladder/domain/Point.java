package ladder.domain;

public class Point {
    private static final int FIRST_INDEX = 0;
    private static final int MOVE_INDEX_DIFFERENCE = 1;

    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(Boolean right) {
        return new Point(FIRST_INDEX, Direction.first(right));
    }

    public static Point of(int index, Direction direction) {
        return new Point(index, direction);
    }

    public int move() {
        return direction.move(index);
    }

    public Point next() {
        return of(index + MOVE_INDEX_DIFFERENCE, direction.next());
    }

    public Point next(boolean right) {
        return of(index + MOVE_INDEX_DIFFERENCE, direction.next(right));
    }

    public Point last() {
        return of(index + MOVE_INDEX_DIFFERENCE, direction.last());
    }

    public Direction getDirection() {
        return direction;
    }
}
