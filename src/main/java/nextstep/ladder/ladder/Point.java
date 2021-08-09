package nextstep.ladder.ladder;

import nextstep.ladder.strategy.LadderStrategy;

public class Point {

    public static final int START_LAST_COUNT = 2;
    public static final int CURRENT_DIRECTION = 1;

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Point next(LadderStrategy strategy) {
        return new Point(index + 1, direction.next(strategy));
    }

    public int move() {
        return index + direction.move();
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public boolean untilBeforeLastPoint(int people) {
        return people - START_LAST_COUNT > index;
    }

    public boolean isMovable() {
        return direction.move() == CURRENT_DIRECTION;
    }

    Point next(boolean right) {
        return new Point(index + 1, direction.next(right));
    }
}
