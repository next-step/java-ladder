package ladder.domain;

public class Point {
    private final int index;
    private final Direction direction;

    private Point(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(final boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Point next(final boolean right) {
        return new Point(this.index + 1, Direction.of(canMoveRight(), right));
    }

    public Point last() {
        return new Point(this.index + 1, Direction.last(canMoveRight()));
    }

    public int move() {
        if (canMoveRight()) {
            return index + 1;
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
