package nextstep.ladder.domain;

public class Point {
    public static final Point UNKNOWN = new Point(null, Direction.UNKNOWN);

    private final Position position;
    private final Direction direction;

    private Point(final Position position, final Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point first(final int size, final boolean isConnected) {
        return new Point(
                Position.first(size),
                Direction.first(isConnected)
        );
    }

    public Point next(final boolean isConnected) {
        return new Point(
                position.increase(),
                direction.next(isConnected)
        );
    }

    public Point last() {
        return new Point(
                position.increase(),
                direction.last()
        );
    }

    public Direction getDirection() {
        return direction;
    }
}
