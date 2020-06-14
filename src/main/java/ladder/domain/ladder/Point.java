package ladder.domain.ladder;

public class Point {

    private final Position position;
    private final PointDirection pointDirection;

    private Point(Position position, PointDirection pointDirection) {
        this.position = position;
        this.pointDirection = pointDirection;
    }

    public static Point first(Boolean right) {
        return new Point(0, PointDirection.first(right));
    }

    private Point(int position, PointDirection direction) {
        this(new Position(position), direction);
    }

    public Position move() {
        if (pointDirection.isRight()) {
            return position.right();
        }

        if (pointDirection.isLeft()) {
            return position.left();
        }

        return this.position;
    }

    public Point next(boolean nextRight) {
        return new Point(position.right(), pointDirection.next(nextRight));
    }

    public Point last() {
        return new Point(position.right(), pointDirection.last());
    }

    public PointDirection getPointDirection() {
        return pointDirection;
    }

}
