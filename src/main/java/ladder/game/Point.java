package ladder.game;

import java.util.Objects;

public class Point {
    private Integer point;

    Point(int num) {
        this.point = num;
    }

    public Integer getPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return Objects.equals(point, point1.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
