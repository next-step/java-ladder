package step2.model;

import java.util.Objects;

public class Point {
    private final boolean left;
    private final boolean current;

    public Point(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public boolean getLeft() {
        return left;
    }

    public boolean getCurrent() {
        return current;
    }

    public int changeIndex(int index) {
        return index + Direction.findDirection(this).getMove();
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
