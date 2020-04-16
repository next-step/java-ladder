package ladder;

public class Point {
    private static final int INIT_INDEX = 0;

    private final int index;
    private final Direction direction;

    public static Point first(boolean right) {
        return new Point(INIT_INDEX, Direction.first(right));
    }

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

        return index;
    }

    public Point next(boolean nextRight) {
        return new Point(index + 1, direction.next(nextRight));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }
}
