package ladder;

import java.util.Objects;

import static ladder.Direction.*;

public class Point {
    private final boolean prev;
    private final boolean curr;

    private Point(boolean prev, boolean curr) {
        this.prev = prev;
        this.curr = curr;

        if (prev & curr) {
            throw new IllegalStateException("유효하지 않은 Point 입니다.");
        }
    }

    public static Point first(boolean curr) {
        return new Point(false, curr);
    }

    public Point next(boolean nextCurr) {
        if (this.curr & nextCurr) {
            throw new IllegalStateException("유효하지 않은 Point 입니다.");
        }

        return new Point(curr, nextCurr);
    }

    public Direction move() {
        if (curr) {
            return RIGHT;
        }

        if (prev) {
            return LEFT;
        }

        return PASS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return prev == point.prev && curr == point.curr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prev, curr);
    }

    public boolean isCurr() {
        return curr;
    }
}
