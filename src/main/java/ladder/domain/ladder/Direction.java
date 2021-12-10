package ladder.domain.ladder;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction() {
        this(false, false);
    }

    public Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction createDirection(boolean isRight, LadderStrategy strategy) {
        if (isRight) {
            return new Direction(true, false);
        }
        return new Direction(false, strategy.isEnableLine());
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
        Direction direction = (Direction) o;
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
