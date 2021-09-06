package nextstep.ladder.domain;

public class Point {
    private static final int RIGHT = 1;
    private static final int LEFT = -1;
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (direction.isCurrent()) {
            return index + LEFT;
        }

        if (direction.isNext()) {
            return index + RIGHT;
        }
        return this.index;
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point next(boolean nextPoint) {
        return new Point(index + 1, direction.next(nextPoint));
    }

    public static Point init(boolean nextPoint) {
        return new Point(0, Direction.init(nextPoint));
    }

    public boolean isCurrent() {
        return direction.isCurrent();
    }

    public boolean isNext() {
        return direction.isNext();
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }
}
