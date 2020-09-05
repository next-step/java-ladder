package ladder.domain;

public class Point {

    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public static Point ofFirstPoint(boolean right) {
        return new Point(Direction.of(false, right));
    }

    public static Point ofLastPoint(boolean left) {
        return new Point(Direction.of(left, false));
    }

    public static Point of(Direction direction) {
        return new Point(direction);
    }

    public boolean getLeft() {
        return direction.getLeft();
    }

    public boolean getRight() {
        return direction.getRight();
    }

    public Point getNext() {
        Direction nextDirection = direction.getNext();
        return new Point(nextDirection);
    }
}
