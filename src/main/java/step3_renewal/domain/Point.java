package step3_renewal.domain;

public class Point {
    private int currentPoint;
    private Direction direction;

    public Point(int currentPoint, Direction direction) {
        this.currentPoint = currentPoint;
        this.direction = direction;
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public int move() {
        if (direction.isLeft()) {
            return currentPoint - 1;
        }

        if (direction.isRight()) {
            return currentPoint + 1;
        }

        return currentPoint;
    }

    public Point next(Boolean right) {
        return new Point(currentPoint + 1, direction.next(right));
    }

    public Point last() {
        return new Point(currentPoint + 1, direction.last());
    }

    public boolean isDrawLine() {
        return direction.isLeft();
    }

    @Override
    public String toString() {
        return "Point{" +
                "currentPoint=" + currentPoint +
                ", direction=" + direction +
                '}';
    }
}
