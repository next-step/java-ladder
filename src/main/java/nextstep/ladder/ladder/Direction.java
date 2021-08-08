package nextstep.ladder.ladder;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static nextstep.ladder.util.RandomValueGenerator.generate;

public class Direction {

    private final boolean left;
    private final boolean current;

    private Direction(boolean left, boolean current) {
        validate(left, current);
        this.left = left;
        this.current = current;
    }

    public static Direction of(boolean left, boolean current) {
        return new Direction(left, current);
    }

    public static Direction first(boolean current) {
        return of(FALSE, current);
    }

    public Direction next() {
        if (this.current) {
            return next(FALSE);
        }
        return next(generate());
    }

    public Direction last() {
        return of(this.current, FALSE);
    }

    Direction next(boolean nextCurrent) {
        return of(this.current, nextCurrent);
    }

    int move() {
        if (this.left) {
            return -1;
        }

        if (this.current) {
            return 1;
        }

        return 0;
    }

    private void validate(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalStateException("이전 좌표가 true 이면 현재 좌표는 true 가 될 수 없습니다.");
        }
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
}
