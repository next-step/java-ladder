package nextstep.ladder.ladder;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public int move() {
        return index + direction.move();
    }

    Point next(boolean right) {
        return new Point(index + 1, direction.next(right));
    }
}
