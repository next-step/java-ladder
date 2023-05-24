package nextstep.ladder.domain;

public class Direction {

    private final boolean previous;
    private final boolean current;

    public Direction(boolean previous, boolean current) {
        if (current && previous) {
            throw new IllegalArgumentException("겹치게 사다리를 놓을 수 없습니다!");
        }
        this.previous = previous;
        this.current = current;
    }

    public static Direction of(boolean current) {
        return new Direction(false, current);
    }

    public int move() {
        if (previous){
            return -1;
        }
        if (current) {
            return +1;
        }
        return 0;
    }

    public Direction last() {
        return new Direction(this.current, false);
    }
}
