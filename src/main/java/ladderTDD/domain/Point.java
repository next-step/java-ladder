package ladderTDD.domain;

import ladderTDD.domain.levels.LadderLevel;

public class Point {

    private static final int DEFAULT_ZERO = 0;
    private static final int DEFAULT_ONE = 1;

    private int index;
    Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(Boolean right) {
        return new Point(DEFAULT_ZERO, Direction.first(right));
    }

    public int move() {

        if (this.direction.isLeft()) {
            return this.index - DEFAULT_ONE;
        }

        if (this.direction.isRight()) {
            return this.index + DEFAULT_ONE;
        }

        return this.index;
    }

    public Point next(Boolean right) {
        return new Point(this.index + DEFAULT_ONE, this.direction.next(right));
    }

    public Point next(LadderLevel ladderLevel) {
        return new Point(this.index + DEFAULT_ONE, this.direction.next(ladderLevel));
    }

    public Point last(int lastIndex) {
        return new Point(lastIndex, this.direction.last());
    }

    @Override
    public String toString() {
        if (this.direction.isRight()) {
            return "-----|";
        }

        return "     |";
    }
}
