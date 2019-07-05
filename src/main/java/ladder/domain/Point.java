package ladder.domain;

import ladder.domain.strategy.GeneratorInterface;

public class Point {
    private int i;
    private boolean current;
    private boolean left;

    public Point(int i, boolean current, boolean left) {
        if (i == 0 && left) {
            throw new IllegalArgumentException();
        }

        if (current && left) {
            throw new IllegalArgumentException();
        }

        this.i = i;
        this.current = current;
        this.left = left;
    }


    public static Point first(boolean current) {
        return new Point(0, current, Boolean.FALSE);
    }

    public Point next(boolean current) {
        return new Point(i+1, current, this.current);
    }

    public Point next(GeneratorInterface strategy) {
        if (this.current) {
            return next(false);
        }

        return next(strategy.generate());
    }

    public Point last() {
        return new Point(i+1, Boolean.FALSE, this.current);
    }

    public int move() {
        if (!left && current) {
            return i + 1;
        }


        if (left && !current) {
            return i - 1;
        }

        return i;
    }

    public boolean current() {
        return current;
    }

    @Override
    public String toString() {
        return current + " ";
    }
}
