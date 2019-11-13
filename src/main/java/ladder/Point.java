package ladder;

import ladder.PointState.Direction;

import java.util.Objects;

public class Point {
    private final int index;
    private final PointState pointState;

    public Point(int index, PointState pointState) {
        this.index = index;
        this.pointState = pointState;
    }

    public int move() {
        Direction direction = pointState.move();
        return direction.move(index);
    }

    /**
     * first와 last Point가 아닌 Point를 의미하는가?
     * first와 last Point를 제외하다보니 2를 minus
     *
     * @param people
     * @return
     */
    public boolean untilBeforeLastPoint(int people) {
        return people - 2 > index;
    }

    public boolean isFirstAndLast(int people) {
        return index == 0 || index == people -1;
    }

    public Point next(Boolean current) {
        return new Point(index + 1, pointState.next(current));
    }

    public Point last() {
        return new Point(index + 1, pointState.last());
    }

    public static Point first(Boolean current) {
        return new Point(0, PointState.first(current));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index &&
                Objects.equals(pointState, point.pointState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, pointState);
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", pointState=" + pointState +
                '}';
    }
}
