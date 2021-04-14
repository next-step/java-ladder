package step4.domain;

public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public Position move() {
        if (direction.isRight()) {
            return Position.valueOf(index + 1);
        }

        if (direction.isLeft()) {
            return Position.valueOf(index - 1);
        }

        return Position.valueOf(this.index);
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

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    @Override
    public String toString() {
        return "Point{" +
            "index=" + index +
            ", direction=" + direction +
            '}';
    }
}
