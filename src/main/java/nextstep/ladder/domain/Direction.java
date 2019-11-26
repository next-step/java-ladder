package nextstep.ladder.domain;

import java.util.Objects;

import static nextstep.ladder.util.RandomGenerator.generateBoolean;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-19 03:24
 */
public class Direction {
    private static final int MOVE_LEFT = -1;
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_PASS = 0;

    private final boolean left;
    private final boolean current;

    private Direction(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException("가로 라인은 겹치지 않습니다.");
        }

        this.left = left;
        this.current = current;
    }

    public static Direction of(boolean left, boolean current) {
        return new Direction(left, current);
    }

    public static Direction first(boolean next) {
        return new Direction(Boolean.FALSE, next);
    }

    public Direction next(boolean next) {
        return of(this.current, next);
    }

    public Direction next() {
        if (this.current) {
            return next(Boolean.FALSE);
        }

        return next(generateBoolean());
    }

    public Direction last() {
        return next(Boolean.FALSE);
    }

    public int move() {
        if (this.left) {
            return MOVE_LEFT;
        }

        if (this.current) {
            return MOVE_RIGHT;
        }

        return MOVE_PASS;
    }

    public boolean isPoint() {
        return this.current;
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
