package ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Direction {

    private final boolean left;

    private final boolean right;

    private static final Random random = new Random();

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public static Direction first() {
        return new Direction(false, random.nextBoolean());
    }

    public Direction next() {
        if(right){
            return next(false);
        }
        return next(random.nextBoolean());
    }

    public Direction next(Boolean right) {
        return new Direction(this.right, right);
    }

    public Direction last() {
        return new Direction(this.right, false);
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
        Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

}
