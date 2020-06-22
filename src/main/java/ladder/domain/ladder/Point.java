package ladder.domain.ladder;

public class Point {
    private static final int NEXT = 1;
    private static final int PREV = -1;
    private final int index;

    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean point) {
        return new Point(0, Direction.first(point));
    }

    public Point next() {
        return new Point(this.index + NEXT, direction.next());
    }

    public Point last() {
        return new Point(index + NEXT, direction.last());
    }

    public int move() {
        if (direction.isRight()) {
            return index + NEXT;
        }

        if (direction.isLeft()) {
            return index + PREV;
        }

        return this.index;
    }

    public Direction getDirection() {
        return direction;
    }

}
