package domain;

import static utility.generatorPoint.makeDirection;

public class Point {
    private int index;
    private boolean right;
    private boolean left;

    public Point(int index, boolean left, boolean right) {
        this.index = index;
        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public Point next() {
        if (this.right) {
            return new Point(index + 1, true, false);
        }
        return new Point(index + 1, false, makeDirection());
    }

    public Point last() {
        if (this.right) {
            return new Point(index + 1, true, false);
        }
        return new Point(index + 1, false, false);
    }

    public int getIndex() {
        return index;
    }
}
