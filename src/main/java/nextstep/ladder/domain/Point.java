package nextstep.ladder.domain;

import nextstep.ladder.utils.LadderValidation;

public class Point {

    private boolean left;
    private boolean right;

    public Point() {
    }

    public Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
        LadderValidation.validateLadderPointRule(left, right);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public Point isFirst(boolean right) {
        return new Point(false, right);
    }

    public Point isLast(boolean left) {
        return new Point(left, false);
    }

    public Point next(Point previousPoint, boolean right) {
        if (previousPoint.isRight()) {
            return new Point(previousPoint.isRight(), false);
        }
        return new Point(false, right);
    }

}
