package ladder.domain;

import ladder.utils.ValidateUtil;

public class Point {
    private boolean left;
    private boolean right;

    private Point(boolean left, boolean right) {
        ValidateUtil.validateLadderRule(left, right);
        this.left = left;
        this.right = right;
    }

    public static Point of(boolean left, boolean right) {
        return new Point(left, right);
    }

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public static Point next(Point prevPoint, boolean right) {
        if (prevPoint.isRight()) {
            return new Point(prevPoint.isRight(), false);
        }
        return new Point(false, right);
    }

    public static Point last(boolean left) {
        return new Point(left, false);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
