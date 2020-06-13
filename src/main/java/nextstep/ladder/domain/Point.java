package nextstep.ladder.domain;

public class Point {
    private final int lineIndex;
    private final Direction direction;

    private Point(int lineIndex, Direction direction) {
        this.validateLineIndex(lineIndex);
        this.lineIndex = lineIndex;
        this.direction = direction;
    }

    private void validateLineIndex(int lineIndex) {
        if (lineIndex < 0) {
            throw new IllegalArgumentException("lineIndex not negative number");
        }
    }

    public static Point firstPoint(MovementGenerator movementGenerator) {
        return new Point(0, Direction.first(movementGenerator));
    }

    public static Point lastPoint(Point prevPoint) {
        return new Point(prevPoint.lineIndex + 1, Direction.last(prevPoint.direction));
    }

    public int move() {
        return this.lineIndex + this.direction.move();
    }

    public boolean isRight() {
        return direction.isRight();
    }

    public Point next(MovementGenerator movementGenerator) {
        return new Point(this.lineIndex + 1, this.direction.next(movementGenerator));
    }
}
