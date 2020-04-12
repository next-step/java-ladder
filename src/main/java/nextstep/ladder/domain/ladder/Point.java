package nextstep.ladder.domain.ladder;

class Point {
    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    int move() {
        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return this.index;
    }

    Point next() {
        return new Point(index + 1, direction.next());
    }

    Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    Point last() {
        return new Point(index + 1, direction.last());
    }

    static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    boolean isRightDirection() {
        return direction.isRight();
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}