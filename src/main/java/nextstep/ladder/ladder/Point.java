package nextstep.ladder.ladder;

public class Point {

    public static final int START_LAST_COUNT = 2;

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public int move() {
        return index + direction.move();
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public boolean untilBeforeLastPoint(int people) {
        return people - START_LAST_COUNT > index;
    }

    Point next(boolean right) {
        return new Point(index + 1, direction.next(right));
    }
}
