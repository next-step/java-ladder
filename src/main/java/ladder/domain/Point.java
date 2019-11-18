package ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Point {
    private Boolean point;

    public Point(Boolean point) {
        this.point = point;
    }

    public static Point ofRandom() {
        return new Point(new Random().nextBoolean());
    }

    public boolean checkTrue() {
        return point == Boolean.TRUE;
    }

    public Boolean getPoint() {
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
