package nextstep.ladder.domain;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.right = right;
    }

    public static Object of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Direction)) { return false; }
        final Direction direction = (Direction) o;
        return left == direction.left &&
               right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
