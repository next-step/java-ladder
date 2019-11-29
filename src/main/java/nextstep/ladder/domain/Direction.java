package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
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

    private static final Map<Integer, Direction> DEFINE_DIRECTION = new HashMap<>();

    static {
        DEFINE_DIRECTION.put(MOVE_LEFT, new Direction(Boolean.TRUE, Boolean.FALSE));
        DEFINE_DIRECTION.put(MOVE_PASS, new Direction(Boolean.FALSE, Boolean.FALSE));
        DEFINE_DIRECTION.put(MOVE_RIGHT, new Direction(Boolean.FALSE, Boolean.TRUE));
    }

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
        return getDirection(false, next);
    }

    private static Direction getDirection(boolean left, boolean current) {
        return DEFINE_DIRECTION.values()
                .stream()
                .filter(direction -> direction.valueEquals(left, current))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException());
    }

    public Direction next(boolean next) {
        return getDirection(this.current, next);
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

    private boolean valueEquals(boolean left, boolean current) {
        return this.left == left && this.current == current;
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
