package ladder.domain;

import ladder.util.RandomGenerator;

import java.util.Objects;

public class Direction {
    private final boolean prev;
    private final boolean current;

    private Direction(boolean prev, boolean current) {
        if (prev && current) {
            throw new IllegalArgumentException("한 라인에 두 방향으로 이동할 수 없습니다.");
        }

        this.prev = prev;
        this.current = current;
    }

    public static Direction first(boolean current) {
        return new Direction(false, current);
    }

    public Direction nextRandom() {
        boolean current = RandomGenerator.generate();
        if (this.current) {
            current = false;
        }
        return new Direction(this.current, current);
    }

    public Direction next(boolean current) {
        return new Direction(this.current, current);
    }

    public Direction last() {
        return new Direction(this.current, false);
    }

    public boolean isLeft() {
        return prev && !current;
    }

    public boolean isRight() {
        return !prev && current;
    }

    public boolean isDown() {
        return !prev && !current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return prev == direction.prev && current == direction.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prev, current);
    }
}
