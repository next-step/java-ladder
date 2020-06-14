package ladder.domain.ladder;

public class Point {

    private final int position;
    private final Direction direction;

    private Point(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public int move() {
        if (direction.isRight()) {
            return position + 1;
        }

        if (direction.isLeft()) {
            return position - 1;
        }

        return this.position;
    }

    public Point next() {
        return new Point(position + 1, direction.next());
    }

    public Point next(Boolean right) {
        return new Point(position + 1, direction.next(right));
    }

    public Point last() {
        return new Point(position + 1, direction.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Boolean isMoveRight() {
        return direction.isRight();
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + position +
                ", direction=" + direction +
                '}';
    }
}
