package ladder.domain;

import ladder.stretagy.PointBuildStrategy;

import java.util.Objects;

public class Point {

    private final boolean left;
    private final boolean current;

    public Point(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public static Point createFirstPoint (PointBuildStrategy pointBuildStrategy) {
        return new Point(false, pointBuildStrategy.build());
    }

    public static Point createNextPoint(boolean leftPoint, PointBuildStrategy pointBuildStrategy) {
        if (leftPoint) {
            return new Point(true, false);
        }

        return new Point(false, pointBuildStrategy.build());
    }

    public Point createLastPoint() {
        return new Point(this.current, false);
    }

    public Direction move() {
        if (this.current) {
            return Direction.RIGHT;
        }

        if (this.left) {
            return Direction.LEFT;
        }

        return Direction.STAY;
    }

    public boolean canDraw() {
        return current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left && current == point.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }
}
