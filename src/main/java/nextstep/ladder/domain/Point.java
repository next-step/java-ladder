package nextstep.ladder.domain;

public class Point {

    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return new Point(0, Direction.first(right));
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

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }
}
