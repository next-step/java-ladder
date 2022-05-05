package nextstep.step4.domain;

public class Point {

    private static final int FIRST_COLUMN = 0;
    private static final int NEXT_COLUMN = 1;
    private static final int PREVIOUS_COLUMN = -1;

    private final int column;
    private final Direction direction;

    private Point(int column, Direction direction) {
        this.column = column;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return new Point(FIRST_COLUMN, Direction.first(right));
    }

    public Point next() {
        return new Point(column + NEXT_COLUMN, direction.next());
    }

    public Point next(boolean right) {
        return new Point(column + NEXT_COLUMN, direction.next(right));
    }

    public Point last() {
        return new Point(column + NEXT_COLUMN, direction.last());
    }

    public int move() {
        if (direction.isLeft()) {
            return this.column + PREVIOUS_COLUMN;
        }

        if (direction.isRight()) {
            return this.column + NEXT_COLUMN;
        }

        return this.column;
    }

    public boolean isRight() {
        return direction.isRight();
    }

    @Override
    public String toString() {
        return "Point{" +
                "column=" + column +
                ", direction=" + direction +
                '}';
    }
}
