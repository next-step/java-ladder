package JavaLadder.domain;

import java.util.Objects;

public class Point {
    private int point = 0;

    public Point(int point) {
        this.point = point;
    }

    public Point() {
        this.point = 0;
    }

    public int getPoint() {
        return this.point;
    }

    public void leftMove() {
        this.point--;
    }

    public void RightMove() {
        this.point++;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getPoint());
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
