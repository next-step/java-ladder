package nextstep.laddergame.domain;

public class Point {
    private static final int INDEX_MOVE = 1;

    private Index index;
    private Direction direction;

    public Point(int index) {
        this.index = Index.from(index);
    }

    public Point(int index, Direction direction) {
        this.index = Index.from(index);
        this.direction = direction;
    }

    public static Point create(int index) {
        return new Point(index);
    }

    public static Point createFirst(MovingStrategy movingStrategy) {
        return Point.of(0, movingStrategy);
    }

    public static Point createLastWithBeforePoint(Point beforePoint) {
        if (beforePoint.canRight()) {
            return new Point(beforePoint.nextIndex(), Direction.LEFT);

        }
        return new Point(beforePoint.nextIndex(), Direction.NOT_MOVE);
    }

    public static Point createWithBeforePoint(Point beforePoint, MovingStrategy movingStrategy) {
        if (beforePoint.canRight()) {
            return new Point(beforePoint.nextIndex(), Direction.LEFT);
        }
        if (beforePoint.canLeft()) {
            return new Point(beforePoint.nextIndex(), Direction.NOT_MOVE);
        }
        return Point.of(beforePoint.nextIndex(), movingStrategy);
    }

    private static Point of(int index, MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            return new Point(index, Direction.RIGHT);
        }

        return new Point(index, Direction.NOT_MOVE);
    }

    private int nextIndex() {
        return this.index.getIndex() + INDEX_MOVE;
    }

    public int getIndex() {
        return index.getIndex();
    }

    public int move() {
        return this.direction.moveLine(this.index.getIndex());
    }

    public boolean isEqualTo(int index) {
        return this.index.isEqualTo(index);
    }

    public boolean canRight() {
        return this.direction.isRight();
    }

    public boolean canLeft() {
        return this.direction.isLeft();
    }

    public boolean canNotMove() {
        return this.direction.isNotMove();
    }
}
