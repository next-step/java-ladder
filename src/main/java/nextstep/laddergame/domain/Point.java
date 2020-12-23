package nextstep.laddergame.domain;

public class Point {
    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final int ZERO = 0;

    private Index index;
    private Direction direction;

    public Point(int index) {
        this.index = Index.from(index);
    }

    public Point(int index, int direction) {
        this.index = Index.from(index);
        this.direction = Direction.from(direction);
    }

    public static Point create(int index) {
        return new Point(index);
    }

    public static Point createFirst(MovingStrategy movingStrategy) {
        return Point.of(0, movingStrategy);
    }

    public static Point createLastWithBeforePoint(Point beforePoint) {
        if (beforePoint.getDirection().isRight()) {
            return new Point(beforePoint.nextIndex(), LEFT);
        }
        return new Point(beforePoint.nextIndex(), ZERO);
    }

    public static Point createWithBeforePoint(Point beforePoint, MovingStrategy movingStrategy) {
        if (beforePoint.getDirection().isRight()) {
            return new Point(beforePoint.nextIndex(), LEFT);
        }
        if (beforePoint.getDirection().isLeft()) {
            return new Point(beforePoint.nextIndex(), ZERO);
        }

        return Point.of(beforePoint.nextIndex(), movingStrategy);
    }

    private static Point of(int index, MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            return new Point(index, RIGHT);
        }

        return new Point(index, ZERO);
    }

    private int nextIndex() {
        return this.index.getIndex() + RIGHT;
    }

    public int getIndex() {
        return index.getIndex();
    }

    public Direction getDirection() {
        return direction;
    }

    public int move() {
        return this.index.getIndex() + this.direction.getDirection();
    }

    public boolean isEqualTo(int index) {
        return this.index.isEqualTo(index);
    }
}
