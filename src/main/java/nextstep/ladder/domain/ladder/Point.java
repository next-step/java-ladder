package nextstep.ladder.domain.ladder;

public class Point {
    private final int index;
    private final Direction direction;

    private static final int FIRST_INDEX = 0;
    private static final int INDEX_INCREMENT = 1;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public Point next() {
        return new Point(index + INDEX_INCREMENT, direction.next());
    }

    public Point last() {
        return new Point(index + INDEX_INCREMENT, direction.last());
    }

    public static Point first(Boolean right) {
        return new Point(FIRST_INDEX, Direction.first(right));
    }

    public Direction getDirection() {
        return direction;
    }
}
