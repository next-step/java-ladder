package nextstep.ladder.domain;

public class Point {
    private final int index;
    private final Direction direction;
    private final int MOVE_DISTANCE = 1;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (direction.isRight()) {
            return index + MOVE_DISTANCE;
        }

        if (direction.isLeft()) {
            return index - MOVE_DISTANCE;
        }

        return this.index;
    }

    public Point next() {
        return new Point(index + MOVE_DISTANCE, direction.next());
    }

    public Point next(Boolean right) {
        return new Point(index + MOVE_DISTANCE, direction.next(right));
    }

    public Point last() {
        return new Point(index + MOVE_DISTANCE, direction.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public boolean isConnected() {
        return direction.isRight();
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
