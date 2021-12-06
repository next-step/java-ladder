package ladder.domain;

import java.util.Objects;

public class Point {

    private final Position position;
    private final boolean left;
    private final boolean right;

    public Point(Position position, boolean left, boolean right) {
        this.position = position;
        this.left = left;
        this.right = right;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left && right == point.right && Objects.equals(position, point.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, left, right);
    }

    @Override
    public String toString() {
        return "Point{" +
                "position=" + position +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

}

