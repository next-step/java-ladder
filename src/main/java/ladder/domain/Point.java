package ladder.domain;

import java.util.Objects;

public class Point {
    private static final String POINT_ERROR_MESSAGE = "위치는 0보다 작을 수 없습니다.";

    private final int point;

    public Point(String point) {
        this(Integer.parseInt(point));
    }

    public Point(int point) {
        validateValue(point);
        this.point = point;
    }

    private void validateValue(int point) {
        if (point < 0) {
            throw new IllegalArgumentException(POINT_ERROR_MESSAGE);
        }
    }

    public int getPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return point == point1.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }

}
