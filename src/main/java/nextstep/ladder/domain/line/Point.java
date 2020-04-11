package nextstep.ladder.domain.line;

public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
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

    public Point next() {
        return new Point(index + 1, direction.getNext());
    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.getNext(right));
    }

    public Point last() {
        return new Point(index + 1, direction.getLast());
    }

    public boolean hasRightDirection() {
        return direction.isRight();
    }

    public static Point first() {
        return first(new RandomDirectionSelector());
    }

    public static Point first(DirectionSelector directionSelector) {
        return new Point(0, Direction.createFirst(directionSelector));
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}