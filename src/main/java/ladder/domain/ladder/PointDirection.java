package ladder.domain.ladder;

import java.util.Objects;

public class PointDirection {

    private final boolean left;
    private final boolean right;

    private PointDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }
        this.left = left;
        this.right = right;
    }

    public static PointDirection of(boolean left, boolean current) {
        return new PointDirection(left, current);
    }

    public static PointDirection first(boolean left, boolean current) {
        return of(left, current);
    }

    public static PointDirection next(PointDirection direction, boolean current) {
        if (direction.isRight()) {
            return of(true, false);
        }
        return of(false, current);
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PointDirection direction = (PointDirection) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "left=" + left +
                ", right=" + right;
    }

}
