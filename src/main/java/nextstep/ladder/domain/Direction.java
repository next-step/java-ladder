package nextstep.ladder.domain;

import nextstep.ladder.util.RandomGenerator;

import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-19 03:24
 */
public class Direction {
    private final boolean left;
    private final boolean current;

    private Direction(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public static Direction of(boolean left, boolean current) {
        return new Direction(left, current);
    }

    public static Direction first() {
        return new Direction(Boolean.FALSE, RandomGenerator.generateBoolean());
    }

    public Direction next(boolean next) {
        return new Direction(this.current, next);
    }

    public boolean isNextFalse(boolean nextPoint) {
        return this.current && nextPoint;
    }

    public boolean isPoint() {
        return this.current;
    }

    public int move() {
        if (this.left) {
            return -1;
        }

        if (this.current) {
            return 1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                current == direction.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }
}
