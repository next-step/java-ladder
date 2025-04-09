package laddergameRDD.domain;

import static laddergameRDD.common.Constants.*;

public class Point {
    private final boolean previous;
    private final boolean current;

    public Point(boolean previous, boolean current) {
        validate(previous, current);
        this.previous = previous;
        this.current = current;
    }

    private static void validate(boolean previous, boolean current) {
        if (previous && current) {
            throw new IllegalArgumentException("사다리의 가로 선이 연달아 생성될 수 없습니다.");
        }
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Point next(boolean nextValue) {
        if (this.current) {
            return new Point(this.current, false);
        }
        return new Point(this.current, nextValue);
    }

    public Point end() {
        return new Point(current, false);
    }

    public int move() {
        if (previous) {
            return LEFT;
        }
        if (current){
            return RIGHT;
        }
        return DOWN;
    }

    public boolean getPoint() {
        return previous;
    }
}
