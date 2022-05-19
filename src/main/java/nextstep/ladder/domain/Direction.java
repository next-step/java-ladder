package nextstep.ladder.domain;

import static java.lang.Boolean.FALSE;
import static nextstep.ladder.utils.LadderPointGenerator.generatePoint;

import java.util.Objects;

public class Direction {
    private static final String CANNOT_CONNET_BIDIRECTION = "양방향 연결은 불가함.";
    private boolean left;
    private boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException(CANNOT_CONNET_BIDIRECTION);
        }

        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        if (this.right) {
            return next(FALSE);
        }
        return next(generatePoint());
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return left == pair.left &&
            right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "{" +
            "" + left +
            ", " + right +
            '}';
    }

    protected void set(Direction direction) {
        this.left = direction.left;
        this.right = direction.right;
    }

}
