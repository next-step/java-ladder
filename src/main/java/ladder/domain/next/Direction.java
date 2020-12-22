package ladder.domain.next;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if( left && right ) throw new IllegalStateException("한쪽 방향으로만 이동할 수 있습니다");

        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public Direction next(boolean nextRight) {
        return of(right, nextRight);
    }

    public Direction next() {
        if( right ) return of(true, false);
        return of(false, DirectionGenerator.generate());
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public Direction last() {
        return of(right, false);
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
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
