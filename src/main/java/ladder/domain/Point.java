package ladder.domain;

import java.util.Objects;

public class Point {
    private final int position;
    private final boolean left;
    private final boolean right;

    protected Point(int position, boolean left, boolean right) {
        this.position = position;
        this.left = left;
        this.right = right;
    }

    public static Point create(RungGenerator generator) {
        return new Point(0, false, generator.isConnected());
    }

    public Point createNext(RungGenerator generator) {
        boolean connect = !this.right && generator.isConnected();
        return new Point(position + 1, this.right, connect);
    }

    public Point createLast() {
        return new Point(position + 1, this.right, false);
    }

    public int move() {
        if (left) return position - 1;
        if (right) return position + 1;
        return position;
    }

    public boolean isMoveRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position && left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, left, right);
    }
}
