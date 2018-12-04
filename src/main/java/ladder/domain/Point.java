package ladder.domain;

public class Point {

    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point create(int index, Direction direction) {
        return new Point(index, direction);
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

    public Point next() {
        return create(index + 1, direction.next());
    }

    public Point next(Boolean right) {
        return create(index + 1, direction.next(right));
    }

    public Point last() {
        return create(index + 1, direction.last());
    }

    public static Point first(Boolean right) {
        return create(0, Direction.first(right));
    }

    @Override
    public String toString() {
        return direction.toString();
    }
}
