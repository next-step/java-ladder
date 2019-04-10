package ladder.domain;

public class Point {
    private final int index;
    private final Direction direction;

    private Point(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    static Point first(final boolean right) {
        return new Point(0, Direction.first(right));
    }

    Point next(final boolean right) {
        return new Point(this.index + 1, Direction.of(canMoveRight(), right));
    }

    Point last() {
        return new Point(this.index + 1, Direction.last(canMoveRight()));
    }

    int move() {
        if (canMoveRight()) {
            return this.index + 1;
        }
        if (canMoveLeft()) {
            return this.index - 1;
        }
        return this.index;
    }

    public boolean canMoveLeft() {
        return this.direction.isLeft();
    }

    public boolean canMoveRight() {
        return this.direction.isRight();
    }

    public int getIndex() {
        return index;
    }
}
