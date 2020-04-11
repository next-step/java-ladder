package nextstep.ladder.domain.direction;

import nextstep.ladder.domain.direction.strategy.Movement;
import nextstep.ladder.domain.direction.strategy.RandomMovement;

import java.util.Objects;

/**
 * 각 Point의 좌/우 방향을 Direction으로 추상화
 * 각 Point의 좌/우 방향 정보를 가진다.
 * 현재 Point에서 다음 Point를 생성하는 역할
 */
public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        validDirection(left, right);
        this.left = left;
        this.right = right;
    }

    private void validDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양방향은 만들수 없습니다.");
        }
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public static Direction left() {
        return new Direction(true, false);
    }

    public static Direction right(Movement movement) {
        return new Direction(false, movement.isMovable());
    }

    public Direction next() {
        if (right) {
            return left();
        }
        return right(new RandomMovement());
    }

    public Direction last() {
        if (right) {
            return left();
        }
        return new Direction(false, false);
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
