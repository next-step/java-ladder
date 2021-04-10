package ladder;

import java.util.Objects;

public class Point {
    private final int index;
    private String position;

    public Point(int index, String position) {
        this.index = index;
        this.position = position;
    }

    public boolean isFirst() {
        return position("FIRST");
    }

    public boolean isLast() {
        return position("LAST");
    }

    private boolean position(String position) {
        return this.position.equals(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && Objects.equals(position, point.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, position);
    }
}
