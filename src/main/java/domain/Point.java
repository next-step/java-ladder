package domain;

import utils.StringUtils;

public class Point {
    private final int LINE_WIDTH = 5;

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (this.direction.isRight()) {
            return this.index + 1;
        } else {
            return this.direction.isLeft() ? this.index - 1 : this.index;
        }
    }

    public Point next(Difficult difficult) {
        return new Point(this.index + 1, this.direction.next(difficult));
    }

    public Point next(Boolean right) {
        return new Point(this.index + 1, this.direction.next(right));
    }

    public Point last() {
        return new Point(this.index + 1, this.direction.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public String toString() {
        if (direction.isRight()) {
            return StringUtils.getReplace(StringUtils.MID_BAR, LINE_WIDTH);
        }
        return StringUtils.getReplace(StringUtils.SPACE, LINE_WIDTH);
    }

}
