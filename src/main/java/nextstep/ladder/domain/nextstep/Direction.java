package nextstep.ladder.domain.nextstep;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Direction {

    private final boolean previous;
    private final boolean current;


    public Direction(boolean previous, boolean current) {
        if (current && previous) {
            current = false;
        }
        this.previous = previous;
        this.current = current;
        validateDuplicate(previous, current);
    }

    private void validateDuplicate(boolean previous, boolean current) {
        if (previous && current) {
            throw new IllegalArgumentException("연속으로 다리를 놓을 수 없습니다!");
        }
    }

    public static Direction first(boolean current) {
        return new Direction(false, current);
    }

    public Direction last() {
        return new Direction(this.current, false);
    }

    public int move() {
        if (previous) {
            return -1;
        }
        if (current) {
            return 1;
        }
        return 0;
    }

    public Direction next(boolean current) {
        if (this.current) {
            return new Direction(this.current, false);
        }
        return new Direction(this.current, current);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return previous == direction.previous && current == direction.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(previous, current);
    }

    public List<Boolean> get() {
        return Arrays.asList(previous, current);
    }
}
