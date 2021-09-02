package ladderrefactoring.domain.ladder;

import java.util.Objects;

public class Point {
    private final int index;
    private final boolean left;
    private final boolean right;


    public Point(int index, boolean left, boolean right) {
        this.index = index;
        this.left = left;
        this.right = right;
    }

    public int move() {
        if(left) {
            return index - 1;
        }
        if(right) {
            return index + 1;
        }
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return index == point.index && left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, left, right);
    }
}
