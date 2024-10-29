package nextstep.ladder.domain;

import java.util.Objects;

public class Point {

    private boolean left;
    private boolean right;

    public Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public Point() {
        this(false, false);
    }

    public boolean hasTrue() {
        return left || right;
    }

    public void connectLeft() {
        this.left = true;
    }

    public void connectRight() {
        this.right = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
