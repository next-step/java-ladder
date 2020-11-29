package ladder.domain;


public class Point {
    private static final DirectionGenerator DEFAULT_DIRECTION_GENERATOR = new RandomDirectionGenerator();

    private final int index;
    private final Direction direction;

    private Point(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point of(final int index, final boolean left, final boolean right) {
        final Direction direction = Direction.valueOf(left, right);
        return new Point(index, direction);
    }

    public static Point createFirst() {
        return createFirst(DEFAULT_DIRECTION_GENERATOR);
    }

    public static Point createFirst(final DirectionGenerator directionGenerator) {
        return new Point(0, directionGenerator.generateFirst());
    }

    public Point createNext() {
        return createNext(DEFAULT_DIRECTION_GENERATOR);
    }

    public Point createNext(final DirectionGenerator directionGenerator) {
        final int nextPointsIndex = this.index + 1;
        final Direction nextPointsDirection = directionGenerator.generateNext(this.direction);
        return new Point(nextPointsIndex, nextPointsDirection);
    }

    public Point createLast() {
        return Point.of(this.index + 1, direction.hasRight(), Boolean.FALSE);
    }

    public boolean hasLeft() {
        return direction.hasLeft();
    }

    public boolean hasRight() {
        return direction.hasRight();
    }

}