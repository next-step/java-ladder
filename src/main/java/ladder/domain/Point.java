package ladder.domain;

public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(Link right) {
        return new Point(0, Direction.first(right));
    }

    public int move() {
        if (direction.isLeft()) {
            return index - 1;
        }

        if (direction.isRight()) {
            return index + 1;
        }

        return index;
    }

    public Point next(Link current) {
        return new Point(this.index + 1, direction.next(current));
    }

    public Point last() {
        return new Point(this.index + 1, direction.last());
    }
}
