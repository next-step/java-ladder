package ladder.domain.ladder;

public class Point {
    private static final int FIRST_INDEX = 0;

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        validateIndex(index);

        this.index = index;
        this.direction = direction;
    }

    @Override
    public String toString() {
        if (canMoveRight()) {
            return "|-----";
        }

        return "|     ";
    }

    static Point first(boolean right) {
        return new Point(FIRST_INDEX, Direction.first(right));
    }

    Point next() {
        return new Point(this.index + 1, this.direction.next(Boolean.FALSE));
    }

    Point next(boolean right) {
        return new Point(this.index + 1, this.direction.next(right));
    }

    Point last() {
        return next(Boolean.FALSE);
    }

    int move() {
        if (canMoveLeft()) {
            return this.index - 1;
        }

        if (canMoveRight()) {
            return this.index + 1;
        }

        return this.index;
    }

    boolean canMoveLeft() {
        return this.direction.isLeft();
    }

    boolean canMoveRight() {
        return this.direction.isRight();
    }

    int getIndex() {
        return this.index;
    }

    private void validateIndex(int index) {
        if (index < FIRST_INDEX) {
            throw new IllegalArgumentException("A value of index must be at least " + FIRST_INDEX);
        }
    }
}
