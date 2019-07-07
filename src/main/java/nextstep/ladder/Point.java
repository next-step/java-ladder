package nextstep.ladder;

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

    public static Point first(BooleanFunction booleanFunction) {
        return new Point(0, Direction.first(booleanFunction));
    }

    public Point next(boolean right) {
        return new Point(this.index + 1, direction.next(right));
    }

    public Point next(BooleanFunction booleanFunction) {
        return new Point(this.index + 1, direction.next(booleanFunction));
    }

    public Point last() {
        return new Point(this.index + 1, direction.last());
    }

    public boolean isLeft() {
        return direction.isLeft();
    }

    public boolean isRight() {
        return direction.isRight();
    }

    public int move() {
        if (this.isLeft()) {
            return this.index - 1;
        }

        if (this.isRight()) {
            return this.index + 1;
        }

        return this.index;

    }
}
