package rick.domain;

import java.util.Objects;

public class Point {

    private static final String MESSAGE_UNI_DIRECTION_ONLY = "양 방향으로 갈 수 없습니다.";

    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(MESSAGE_UNI_DIRECTION_ONLY);
        }

        this.left = left;
        this.right = right;
    }

    public Point next(boolean nextRight) {
        if (this.right) {
            return new Point(this.right, false);
        }

        return new Point(this.right, nextRight);
    }

    public Point last() {
        return new Point(this.right, false);
    }

    public boolean movableToLeft() {
        return left;
    }

    public boolean movableToRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

}
