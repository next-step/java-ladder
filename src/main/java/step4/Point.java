package step4;

import step4.exceptions.BothTrueException;

public class Point {
    private final int position;
    private final boolean before;
    private final boolean current;

    public Point(int position, boolean before, boolean current) {
        if (before && current) {
            throw new BothTrueException();
        }
        this.position = position;
        this.before = before;
        this.current = current;
    }


    public static Point first(boolean current) {
        return new Point(0, false, current);
    }

    public int move() {
        Direction direction = new Cross(before, current).move();
        if (direction == Direction.RIGHT) {
            return position + 1;
        }
        if (direction == Direction.LEFT) {
            return position - 1;
        }
        return position;
    }

    public Point next(boolean current) {
        return new Point(this.position + 1, this.current, current);
    }
}

