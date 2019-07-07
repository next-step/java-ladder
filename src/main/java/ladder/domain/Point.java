package ladder.domain;

import ladder.domain.strategy.GeneratorInterface;

public class Point {
    private int position;
    private boolean current;
    private boolean left;

    public Point(int position, boolean current, boolean left) {
        if (position == 0 && left) {
            throw new IllegalArgumentException();
        }

        if (current && left) {
            throw new IllegalArgumentException();
        }

        this.position = position;
        this.current = current;
        this.left = left;
    }


    public static Point first(boolean current) {
        return new Point(0, current, Boolean.FALSE);
    }

    public Point next(boolean current) {
        return new Point(getNextIndex(), current, this.current);
    }

    public Point next(GeneratorInterface strategy) {
        if (this.current) {
            return next(false);
        }

        return next(strategy.generate());
    }

    public Point last() {
        return new Point(getNextIndex(), Boolean.FALSE, this.current);
    }

    public int move() {
        if (!left && current) {
            return position + 1;
        }


        if (left && !current) {
            return position - 1;
        }

        return position;
    }

    public boolean current() {
        return current;
    }

    private int getNextIndex() {
        return position+1;
    }

    @Override
    public String toString() {
        return current + " ";
    }
}
