package ladder.domain.ladder;

public class Point {
    private static final DirectionGenerator DEFAULT_DIRECTION_GENERATOR = new RandomDirectionGenerator();

    private final int index;
    private final Direction direction;

    private Point(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point of(final int index, final Direction direction) {
        if (direction == null) {
            return new Point(index, Direction.NONE);
        }
        return new Point(index, direction);
    }

    public static Point createFirst() {
        return createFirst(DEFAULT_DIRECTION_GENERATOR);
    }

    public static Point createFirst(final DirectionGenerator directionGenerator) {
        return Point.of(0, directionGenerator.generateFirst());
    }

    public Point createNext() {
        return createNext(DEFAULT_DIRECTION_GENERATOR);
    }

    public Point createNext(final DirectionGenerator directionGenerator) {
        final int nextPointsIndex = this.index + 1;
        final Direction nextPointsDirection = directionGenerator.generateNext(this.direction);
        return Point.of(nextPointsIndex, nextPointsDirection);
    }

    public Point createLast() {
        final Direction lastPointsDirection = DEFAULT_DIRECTION_GENERATOR.generateLast(this.direction);
        return Point.of(this.index + 1, lastPointsDirection);
    }

    public boolean hasLeft() {
        return direction.hasLeft();
    }

    public boolean hasRight() {
        return direction.hasRight();
    }

    public int move() {
        return direction.move(index);
    }
}