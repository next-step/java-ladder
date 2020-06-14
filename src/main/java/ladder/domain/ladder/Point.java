package ladder.domain.ladder;

public class Point {

    private final int position;
    private final PointDirection pointDirection;

    private Point(int position, PointDirection pointDirection) {
        this.position = position;
        this.pointDirection = pointDirection;
    }

    public int move() {
        if (pointDirection.isRight()) {
            return position + 1;
        }

        if (pointDirection.isLeft()) {
            return position - 1;
        }

        return this.position;
    }

    public Point next() {
        return new Point(position + 1, pointDirection.next());
    }

    public Point next(Boolean right) {
        return new Point(position + 1, pointDirection.next(right));
    }

    public Point last() {
        return new Point(position + 1, pointDirection.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, PointDirection.first(right));
    }

    public Boolean isMoveRight() {
        return pointDirection.isRight();
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + position +
                ", direction=" + pointDirection +
                '}';
    }
}
