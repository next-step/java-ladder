package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

import java.util.Objects;

public class Direction {
    private final boolean current;
    private final boolean next;

    private Direction(boolean current, boolean next) {
        if (current && next) {
            throw new IllegalArgumentException("유효한 사다리가 아닙니다.");
        }
        this.current = current;
        this.next = next;
    }

    public static Direction init(boolean nextPoint) { // 가로 Line 처음 Point 값 지정
        return new Direction(false, nextPoint);
    }

    public static Direction of(boolean currentPoint, boolean nextPoint) {
        return new Direction(currentPoint, nextPoint);
    }


    public Direction last() { // 가로 Line 마지막 Point 값 지정
        return new Direction(this.next, false);
    }

    public Direction next() {
        if (this.next) {
            return next(false);
        }
        return next(RandomUtil.generate());
    }

    public Direction next(boolean nextPoint) {
        return of(this.next, nextPoint);
    }

    public boolean isCurrent() {
        return current;
    }

    public boolean isNext() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return current == direction.current && next == direction.next;
    }

    @Override
    public int hashCode() {
        return Objects.hash(current, next);
    }
}
