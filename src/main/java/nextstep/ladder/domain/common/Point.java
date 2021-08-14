package nextstep.ladder.domain.common;

public class Point {

    private final int index;
    private final Direction direction;

    private Point(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point of(final int index, final Direction direction) {
        return new Point(index, direction);
    }

    public static Point first() {
        return new Point(0, Direction.first());
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public int move() {
        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return this.index;
    }

    public boolean isPossibleFirst() {
        return !direction.isLeft();
    }

    public boolean isPossibleLast() {
        return !direction.isRight();
    }

    public boolean isPossibleNext(final Point next) {
        return direction.isPossibleNext(next.direction)
            && this.index == next.index - 1;
    }

    public boolean getLeft() {
        return direction.isLeft();
    }
}
