package ladder.domain;

import ladder.ladderexceptions.InvalidLayoutException;

import java.util.Objects;

public class Point {
    private boolean leftSideStatus;
    private boolean atStatus;

    private int index;
    private PointStatus pointStatus;

    public static Point first(boolean atPointStatus) {
        return custom(false, atPointStatus);
    }

    public Point next(boolean atStatus) {
        return Point.custom(this.atStatus, atStatus);
    }

    public Point last() {
        return custom(this.atStatus, atStatus);
    }

    public static Point custom(boolean leftSideStatus, boolean atPointStatus) {
        return new Point(leftSideStatus, atPointStatus);
    }

    private Point(boolean leftSideStatus, boolean atPointStatus) {
        validateStatus(leftSideStatus, atPointStatus);
        this.leftSideStatus = leftSideStatus;
        this.atStatus = atPointStatus;
    }

    private Point(int index, PointStatus pointStatus) {
        this.index = index;
        this.pointStatus = pointStatus;
    }

    public static Point first1(boolean atStatus) {
        return custom1(0, PointStatus.first(atStatus));
    }

    public static Point custom1(int index, PointStatus status) {
        return new Point(index, status);
    }

    private void validateStatus(boolean leftSideStatus, boolean atPointStatus) {
        if (leftSideStatus && atPointStatus) {
            throw new InvalidLayoutException();
        }
    }

    public int nextIndex(int startingIndex) {
        if (!leftSideStatus && atStatus) {
            return startingIndex + 1;
        }
        if (leftSideStatus && !atStatus) {
            return startingIndex - 1;
        }

        return startingIndex;
    }

    public Point next1(boolean atStatus) {
        return custom1(index + 1, pointStatus.next(atStatus));
    }

    public Point last1() {
        return custom1(index + 1, pointStatus.last());
    }

    public int nextIndex1() {
        return pointStatus.nextIndex(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return leftSideStatus == point.leftSideStatus && atStatus == point.atStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftSideStatus, atStatus);
    }
}
