package ladder.domain;

public class Point {

    private final int index;

    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public static Point first() {
        return new Point(0, Direction.first());
    }

    public int movableIndex() {
        if (direction.isLeft()) {
            return index - 1;
        }
        if (direction.isRight()) {
            return index + 1;
        }
        return index;
    }

    public boolean hasLeftDirection() {
        return direction.isLeft();
    }

    public boolean hasRightDirection() {
        return direction.isRight();
    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

}
