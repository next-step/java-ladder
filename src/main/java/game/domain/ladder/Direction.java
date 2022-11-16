package game.domain.ladder;

import game.util.RandomValueGenerator;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) throw new IllegalArgumentException("왼쪽/오른쪽 한 방향으로만 설정해주세요.");

        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction right(boolean right) {
        return of(false, right);
    }

    public static Direction left(boolean left) {
        return of(left, false);
    }

    public static Direction next(boolean nextLeft, boolean nextRight) {
        if (nextLeft && nextRight) {
            return nextLeftOrRight();
        }

        return Direction.of(nextLeft, nextRight);
    }

    private static Direction nextLeftOrRight() {
        int randomNumber = RandomValueGenerator.randomNumber(1);
        if (randomNumber == 0) {
            return left(true);
        }
        return right(true);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public int move() {
        if (left) return -1;
        if (right) return 1;
        return 0;
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
}
