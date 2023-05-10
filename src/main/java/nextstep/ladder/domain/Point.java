package nextstep.ladder.domain;

import java.util.Objects;

@Deprecated
public class Point {
    private final PointType pointType;

    public Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("Point 는 양쪽이 true 일 수 없습니다.");
        }

        this.pointType = getPointType(left, right);
    }

    private PointType getPointType(boolean left, boolean right) {
        if (left) {
            return PointType.LEFT;
        }

        if (right) {
            return PointType.RIGHT;
        }

        return PointType.NONE;
    }


    public Point right(boolean right) {
        return new Point(pointType.right(), right);
    }

    public boolean isRight() {
        return pointType.right();
    }

    public int move() {
        return this.pointType.move();
    }

    public Point(PointType pointType) {
        this.pointType = pointType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return pointType == point.pointType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointType);
    }

    @Override
    public String toString() {
        return "Point{" +
                "pointType=" + pointType +
                '}';
    }
}
