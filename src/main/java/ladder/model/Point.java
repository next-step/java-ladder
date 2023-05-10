package ladder.model;

import java.util.Objects;

public class Point {
    private final Position position;
    private final boolean left;
    private final boolean right;

    public Point(Position position, boolean left, boolean right) {
        validatePoint(left, right);
        this.position = position;
        this.left = left;
        this.right = right;
    }

    public Point(int position, boolean left, boolean right) {
        this(new Position(position), left, right);
    }

    public static Point createFirst(boolean right) {
        return new Point(0, false, right);
    }

    public Point createNext(boolean right) {
        return new Point(this.position.right(), this.right, right);
    }

    public Position move() {
        if (left) {
            return position.left();
        }
        if (right) {
            return position.right();
        }
        return position;
    }

    private void validatePoint(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("사다리 한 위치에 가로 라인이 겹칠 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (left != point.left) return false;
        if (right != point.right) return false;
        return Objects.equals(position, point.position);
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (left ? 1 : 0);
        result = 31 * result + (right ? 1 : 0);
        return result;
    }
}
