package nextstep.ladder.domain;

public class Point {

    private final int sequence;
    private final Direction direction;

    private Point(int sequence, Direction direction) {
        this.sequence = sequence;
        this.direction = direction;
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Point next() {
        return new Point(sequence + 1, direction.next());
    }

    public Point last() {
        return new Point(sequence + 1, direction.last());
    }

    public boolean left() {
        return direction.left();
    }

    public boolean right() {
        return direction.right();
    }
}
