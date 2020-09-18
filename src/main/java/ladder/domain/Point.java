package ladder.domain;

public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return this.index;
    }

    public static Point first() {
        return new Point(0, Direction.first());
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public Direction getDirection() {
        return direction;
    }

}
