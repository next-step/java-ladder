package ladder.domain;

import static util.Preconditions.checkArgument;

public class Point {
    public static final String POINT_MUST_HAS_ONLY_ONE_DIRECTION = "point must has only one direction";
    private static final DirectionGenerator DEFAULT_DIRECTION_GENERATOR = new RandomDirectionGenerator();

    private final int index;
    private final Direction direction;

    private Point(final int index, final boolean left, final boolean right) {
        this.index = index;
        this.direction = Direction.valueOf(left, right);
    }

    public static Point of(final int index, final boolean left, final boolean right) {
        checkArgument(!(left && right), POINT_MUST_HAS_ONLY_ONE_DIRECTION);
        return new Point(index, left, right);
    }

    public static Point createFirst() {
        return createFirst(DEFAULT_DIRECTION_GENERATOR);
    }

    public static Point createFirst(final DirectionGenerator directionGenerator) {
        return Point.of(0, Boolean.FALSE, directionGenerator.generate());
    }

    public Point createNext() {
        return createNext(DEFAULT_DIRECTION_GENERATOR);
    }

    public Point createNext(final DirectionGenerator directionGenerator) {
        final int nextPointsIndex = this.index + 1;
        if (direction.hasRight()) {
            return Point.of(nextPointsIndex, Boolean.TRUE, Boolean.FALSE);
        }

        final boolean nextPointsRight = directionGenerator.generate();
        return Point.of(nextPointsIndex, Boolean.FALSE, nextPointsRight);
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