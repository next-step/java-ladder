package laddergame.v2.domain;

public class Position {

    private final int value;
    private final Point point;

    private Position(final int value, final Point point) {
        this.value = value;
        this.point = point;
    }

    public static Position first(final boolean right) {
        return new Position(0, Point.first(right));
    }

    public Position next(final boolean right) {
        return new Position(value + 1, point.next(right));
    }

    public Position next() {
        return new Position(value + 1, point.next());
    }

    public Position last() {
        return new Position(this.value + 1, point.last());
    }

    public int move() {
        return value + point.move().getOffset();
    }
}
