package ladder.domain.ladder;

import ladder.domain.strategy.LineStrategy;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        return direction.getNextIndex(index);
    }

    public Point next(LineStrategy lineStrategy) {
        return new Point(index + 1, direction.next(lineStrategy));
    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public boolean isConnectedNextPoint() {
        return direction.hasRightLine();
    }
}
