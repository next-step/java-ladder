package ladder.model;

import ladder.exception.CannotCreateLadderException;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new CannotCreateLadderException("[사다리 생성 에러] 사다리의 가로 라인이 겹칠 수 없습니다.");
        }

        this.left = left;
        this.right = right;
    }

    public boolean isConnectedRight() {
        return this.right;
    }

    public boolean isConnectableNext() {
        return !this.right;
    }

    private static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public Direction next() {
        if (isConnectedRight()) {
            return of(true, false);
        }

        return next(false);
    }

    public Direction next(boolean rightRandom) {
        return of(false, rightRandom);
    }

    public static Direction first(boolean rightRandom) {
        return of(false, rightRandom);
    }

    public Direction last() {
        return of(this.right, false);
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
