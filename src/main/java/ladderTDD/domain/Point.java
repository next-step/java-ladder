package ladderTDD.domain;

import java.util.Random;

public class Point {

    private int index;
    private boolean right;
    private boolean left;

    private Point(int index, boolean left, boolean right) {
        this.index = index;
        this.left = left;
        this.right = right;
    }

    public static Point first(Boolean right) {
        return new Point(0, false, right);
    }

    public int move() {

        if (this.left) {
            return this.index - 1;
        }

        if (this.right) {
            return this.index + 1;
        }

        return this.index;
    }

    public Point next(Boolean right) {
        return new Point(this.index + 1, this.right, right);
    }

    public Point next() {
        if (this.right) {
            return new Point(this.index + 1, this.right, false);
        }
        return new Point(this.index + 1, this.right, new Random().nextBoolean());
    }

    public static Point last(int lastIndex, Boolean left) {
        return new Point(lastIndex, left, false);
    }

    @Override
    public String toString() {
        if (this.right) {
            return "-----|";
        }

        return "     |";
    }
}
