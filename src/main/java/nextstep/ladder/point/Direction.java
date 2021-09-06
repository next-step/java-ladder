package nextstep.ladder.point;

import nextstep.ladder.RandomBooleanGenerator;

import java.util.Objects;

public class Direction {

    private final boolean movableLeft;
    private final boolean movableRight;

    public Direction(boolean movableLeft, boolean movableRight) {
        if (movableLeft && movableRight)
            throw new IllegalArgumentException("양쪽으로 이동 할 수 없습니다");

        this.movableLeft = movableLeft;
        this.movableRight = movableRight;
    }

    public int move() {
        if (isMovableLeft()) {
            return -1;
        }

        if (isMovableRight()) {
            return 1;
        }

        return 0;
    }

    public static Direction first(boolean movableRight) {
        return new Direction(false, movableRight);
    }

    public Direction last() {
        return new Direction(this.movableRight, false);
    }

    public Direction next(boolean next) {
        return new Direction(this.movableRight, next);
    }

    public Direction next() {
        if (this.movableRight)
            return next(false);

        return next(RandomBooleanGenerator.generate());
    }

    public boolean isMovableLeft() {
        return movableLeft;
    }

    public boolean isMovableRight() {
        return movableRight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        Direction direction = (Direction) o;
        return isMovableLeft() == direction.isMovableLeft() && isMovableRight() == direction.isMovableRight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isMovableLeft(), isMovableRight());
    }

    @Override
    public String toString() {
        return "Direction{" +
                "movableLeft=" + movableLeft +
                ", movableRight=" + movableRight +
                '}';
    }
}
