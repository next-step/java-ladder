package ladder.domain.ladder;

import ladder.domain.rule.PositionGenerator;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private final boolean current;

    Direction(boolean left, boolean current) {
        validate(left, current);
        this.left = left;
        this.current = current;
    }

    static Direction first(PositionGenerator current) {
        return new Direction(false, current.generate());
    }

    Direction next(PositionGenerator current) {
        if (this.current) {
            return new Direction(true, false);
        }
        return new Direction(false, current.generate());
    }

    Direction last() {
        return new Direction(this.current, false);
    }

    int move() {
        if (left) {
            return -1;
        }
        if (current) {
            return 1;
        }
        return 0;
    }

    boolean isRight() {
        return current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left && current == direction.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }

    private void validate(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException("좌,우 동시에 이동할 수 없습니다.");
        }
    }
}
