package ladder.domain.ladder;

public final class Point {

    private final int index;
    private final Direction direction;

    private Point(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(final DirectionStrategy directionStrategy) {
        return new Point(0, Direction.ofFirst(directionStrategy));
    }

    public Point next(final DirectionStrategy directionStrategy) {
        return new Point(index + 1, direction.ofNext(directionStrategy));
    }

    public Point last() {
        return new Point(index + 1, direction.ofLast());
    }

    public int move() {
        return index + direction.move();
    }

    public boolean compareDirection(final Direction direction) {
        return this.direction.equals(direction);
    }
}
