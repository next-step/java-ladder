package nextstep.entity;

public class Point {

    private static final int START_INDEX = 0;
    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public boolean hasLeftPedal() {
        return direction.isLeft();
    }

    public boolean hasRightPedal() {
        return direction.isRight();
    }

    public int play() {
        if (direction.isLeft()) {
            return this.index - 1;
        }
        if (direction.isRight()) {
            return this.index + 1;
        }
        return this.index;
    }

    public static Point of(int index, boolean leftPedal, boolean rightPedal) throws IllegalArgumentException {
        return new Point(index, Direction.of(leftPedal, rightPedal));
    }

    public static Point of(int index, Direction direction) throws IllegalArgumentException {
        return new Point(index, direction);
    }

    public Point next(boolean nextRightPedal) {
        return Point.of(this.index + 1, direction.next(nextRightPedal));
    }

    public static Point getStartPoint(boolean nextRightPedal) {
        return Point.of(START_INDEX, Direction.getStartDirection(nextRightPedal));
    }

    public Point getLastPoint() {
        return Point.of(this.index + 1, direction.getLastDirection());
    }

    public static Point getSinglePoint() {
        return Point.of(START_INDEX, Direction.getSingleDirection());
    }
}
