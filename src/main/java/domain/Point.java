package domain;

import java.util.Random;

public class Point {
    private static final String LINE = "|-----";
    private static final String NO_LINE = "|     ";
    private boolean left;
    private boolean right;

    private Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Point first() {
        return new Point(false, generatePoint(false));
    }

    public static Point last(boolean left) {
        return new Point(left, false);
    }

    public static Point next(boolean left) {
        return new Point(left, generatePoint(left));
    }

    public static boolean generatePoint(boolean left) {
        if (left) {
            return false;
        }
        return new Random().nextBoolean();
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    public String lineType(Point point) {
        return point.right ? LINE : NO_LINE;
    }

}
