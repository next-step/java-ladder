package ladder;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static ladder.LadderPointGenerator.generatePoint;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException("왼쪽 오른쪽 모두 이어질 수는 없습니다.");
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public Direction next(PointConnectStrategy pointConnectStrategy) {
        if (this.right) {
            return next(FALSE);
        }
        return next(pointConnectStrategy.isConnected());
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
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
