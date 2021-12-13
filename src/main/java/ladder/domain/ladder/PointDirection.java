package ladder.domain.ladder;

import ladder.strategy.LineStrategy;

import java.util.Objects;

public class PointDirection {

    private final boolean left;
    private final boolean right;

    public PointDirection() {
        this(false, false);
    }

    public PointDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }
        this.left = left;
        this.right = right;
    }

    public static PointDirection createDirection(boolean isRight, LineStrategy strategy) {
        if (isRight) {
            return new PointDirection(true, false);
        }
        return new PointDirection(false, strategy.isEnableLine());
    }

    public static PointDirection createLastDirection(boolean isRight) {
        if (isRight) {
            return new PointDirection(true, false);
        }
        return new PointDirection(false, false);
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
