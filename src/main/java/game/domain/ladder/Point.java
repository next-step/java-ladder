package game.domain.ladder;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return new Point(0, Direction.right(right));
    }

    public static Point last(int index, boolean left) {
        return new Point(index, Direction.left(left));
    }

    public static Point next(int index, Direction direction) {
        return new Point(index, direction);
    }

    public Direction direction() {
        return direction;
    }

    public int move() {
        return index + direction.move();
    }
}
