package ladder;

import java.util.List;
import java.util.Objects;

public class Point {
    private boolean point;

    public Point(boolean point) {
        this.point = point;
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

    public void print() {
        System.out.print("|");
        if (point) {
            System.out.print("-----");
        } else {
            System.out.print("     ");
        }
    }
}
