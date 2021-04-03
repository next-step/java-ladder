package nextstep.ladder.domain;

public class Point {
    private final boolean previous;
    private final boolean current;

    public Point(boolean previous, boolean current) {
        validation(previous, current);
        this.previous = previous;
        this.current = current;
    }

    public void validation(boolean previous, boolean current) {
        if (previous && current) {
            throw new IllegalArgumentException("유효하지 않은 입력값 입니다.");
        }
    }

    public boolean current() {
        return current;
    }

    public Direction nextDirection() {
        if (previous) {
            return Direction.LEFT;
        }

        if (current) {
            return Direction.RIGHT;
        }

        return Direction.DOWN;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public static Point last(boolean previous) {
        return new Point(previous, false);
    }

    public String toString() {
        return nextDirection().displayChar;
    }
}
