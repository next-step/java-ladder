package nextstep.entity;

public class Point {

    private final Direction direction;

    private Point(Direction direction) {
        this.direction = direction;
    }

    public boolean hasLeftPedal() {
        return direction.isLeft();
    }

    public boolean hasRightPedal() {
        return direction.isRight();
    }

    public int play(int index) {
        if (direction.isLeft()) {
            return index - 1;
        }
        if (direction.isRight()) {
            return index + 1;
        }
        return index;
    }

    public static Point of(boolean leftPedal, boolean rightPedal) throws IllegalArgumentException {
        return new Point(Direction.of(leftPedal, rightPedal));
    }

    public static Point of(Direction direction) throws IllegalArgumentException {
        return new Point(direction);
    }

    public Point next(boolean nextRightPedal) {
        return Point.of(direction.next(nextRightPedal));
    }

    public static Point getStartPoint(boolean nextRightPedal) {
        return Point.of(Direction.getStartDirection(nextRightPedal));
    }

    public Point getLastPoint() {
        return Point.of(direction.getLastDirection());
    }

    public static Point getSinglePoint() {
        return Point.of(Direction.getSingleDirection());
    }
}
