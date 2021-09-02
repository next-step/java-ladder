package step3.ladderGame.domain.ladder;

import step3.ladderGame.domain.exception.HaveSeveralDirectionsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public final class Point {

    private static final Random random = new Random();

    private final boolean leftDirection;
    private final boolean rightDirection;

    private Point(final boolean leftDirection, final boolean rightDirection) {
        validate(leftDirection, rightDirection);
        this.leftDirection = leftDirection;
        this.rightDirection = rightDirection;
    }

    private void validate(final boolean left, final boolean right) {
        if (left && right) {
            throw new HaveSeveralDirectionsException();
        }
    }

    public static List<Point> generateFirstPoint() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(false, random.nextBoolean()));
        return points;
    }

    public static Point generatePoint(final Point prePoint) {
        boolean leftDirection = prePoint.hasRightDirectionLine();
        boolean rightDirection = false;

        if (!leftDirection) {
            rightDirection = random.nextBoolean();
        }

        return new Point(leftDirection, rightDirection);
    }

    public static Point generateLastPoint(final Point prePoint) {
        boolean leftDirection = prePoint.hasRightDirectionLine();
        return new Point(leftDirection, false);
    }

    public int move(final int index) {
        if (leftDirection) {
            return index - 1;
        }
        if (rightDirection) {
            return index + 1;
        }
        return index;
    }

    public boolean hasLeftDirectionLine() {
        return leftDirection;
    }

    public boolean hasRightDirectionLine() {
        return rightDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return leftDirection == point.leftDirection &&
                rightDirection == point.rightDirection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftDirection, rightDirection);
    }

}
