package ladder.domain;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean point) {
        return new Point(0, Direction.first(point));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public Point next() {
        return new Point(this.index + 1, direction.next());
    }

    public Point next(boolean point) {
        return new Point(this.index + 1, direction.next(point));
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

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
