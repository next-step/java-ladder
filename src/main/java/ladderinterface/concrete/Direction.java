package ladderinterface.concrete;

import ladderinterface.util.BooleanGenerator;

import java.util.Objects;

public class Direction {
    private final boolean prev;
    private final boolean current;

    private Direction(boolean prev, boolean current) {
        if (prev && current) {
            throw new IllegalArgumentException("라인이 겹치지 않아야 합니다.");
        }
        this.prev = prev;
        this.current = current;
    }

    public static Direction of(boolean prev, boolean current) {
        return new Direction(prev, current);
    }

    public static Direction first(boolean current) {
        return of(false, current);
    }

    public Direction next(BooleanGenerator generator) {
        if (current) {
            return next(false);
        }
        return next(generator.generate());
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

    public int move(int position) {
        if (isLeft()) {
            return position - 1;
        }

        if (isRight()) {
            return position + 1;
        }

        return position;

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
