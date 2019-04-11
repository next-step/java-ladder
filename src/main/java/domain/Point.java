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

    public static Point createPoint(boolean left, boolean right) {
        return new Point(left, right);
    }

    public static boolean isNextPoint(boolean left) {
        if (left) {
            return false;
        }
        return new Random().nextBoolean();
    }

    public int movePoint() {
        if (this.isRightMovable()) {
            return 1;
        } else if (this.isLeftMovable()) {
            return - 1;
        }
        return 0;
    }

    public boolean isLeftMovable() {
        return this.left;
    }

    public boolean isRightMovable() {
        return this.right;
    }

    public String lineType(Point point) {
        return point.right ? LINE : NO_LINE;
    }

}
