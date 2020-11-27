package ladder.domain;

import java.util.Objects;

import static util.Preconditions.checkArgument;

public class Point {
    public static final String POINT_MUST_HAS_ONLY_ONE_DIRECTION = "point must has only one direction";
    private static final DirectionGenerator DEFAULT_DIRECTION_GENERATOR = new RandomDirectionGenerator();
    private final int index;
    private final boolean left;
    private final boolean right;

    private Point(final int index, final boolean left, final boolean right) {
        this.index = index;
        this.left = left;
        this.right = right;
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
        if (this.right) {
            return Point.of(nextPointsIndex, Boolean.TRUE, Boolean.FALSE);
        }

        final boolean nextPointsRight = directionGenerator.generate();
        return Point.of(nextPointsIndex, Boolean.FALSE, nextPointsRight);
    }

    public Point createLast() {
        return Point.of(this.index + 1, this.right, Boolean.FALSE);
    }

    public boolean hasLeft() {
        return left;
    }

    public boolean hasRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index &&
                left == point.left &&
                right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, left, right);
    }
}