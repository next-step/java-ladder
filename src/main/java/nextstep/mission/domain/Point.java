package nextstep.mission.domain;

public class Point {
    private static final int RIGHT = 1;
    private static final int LEFT = 1;

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public int move() {
        if (direction.isRight()) {
            return index + RIGHT;
        }

        if (direction.isLeft()) {
            return index - LEFT;
        }

        return this.index;
    }

    public Point next() {
        return new Point(index + RIGHT, direction.next());
    }

    public Point next(Boolean right) {
        return new Point(index + RIGHT, direction.next(right));
    }

    public Point last() {
        return new Point(index + RIGHT, direction.last());
    }

    public boolean isLeft() {
        return direction.isLeft();
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
