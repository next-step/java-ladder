package ladder.domain;

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

    public Direction next(boolean current) {
        return new Direction(this.current, current);
    }

    public Direction last(boolean current) {
        return new Direction(current, false);
    }

    public boolean isLeft() {
        return prev;
    }

    public boolean isRight() {
        return current;
    }

    public boolean isDown() {
        return !prev && !current;
    }
}
