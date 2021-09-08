package nextstep.ladder.domain;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction2 {
    private final boolean left;
    private final boolean right;

    private Direction2(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
        System.out.println(this);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction2 next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction2 next() {
        if (this.right) {
            return next(FALSE);
        }
        return next(new RandomMakeStrategy().canMake());
    }

    public static Direction2 of(boolean first, boolean second) {
        return new Direction2(first, second);
    }

    public static Direction2 first(boolean right) {
        return of(FALSE, right);
    }

    public Direction2 last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction2 pair = (Direction2) o;
        return left == pair.left &&
                right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
