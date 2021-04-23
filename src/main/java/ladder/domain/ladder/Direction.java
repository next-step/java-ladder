package ladder.domain.ladder;

import static java.lang.Boolean.FALSE;

public final class Direction {

    private final boolean left;
    private final boolean current;

    private Direction(boolean left, boolean current) {
        validate(left, current);
        this.left = left;
        this.current = current;
    }

    private final void validate(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException("상태 값이 유효하지 않습니다.");
        }
    }

    public static final Direction first(boolean current) {
        return new Direction(FALSE, current);
    }

    public final Heading move() {
        return Heading.valueOf(left, current);
    }

    public final Direction next(boolean current) {
        return new Direction(this.current, current);
    }

    public final Direction last() {
        return new Direction(this.current, FALSE);
    }
}
