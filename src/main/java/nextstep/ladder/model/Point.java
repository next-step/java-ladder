package nextstep.ladder.model;

public class Point {
    private static final int TO_RIGHT = 1;
    private static final int TO_LEFT = -1;

    private int index;
    private Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (direction.isLeft()) {
            return index + TO_LEFT;
        }

        if (direction.isRight()) {
            return index + TO_RIGHT;
        }

        return index;
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }
}
