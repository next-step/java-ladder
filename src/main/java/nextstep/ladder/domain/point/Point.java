package nextstep.ladder.domain.point;

import nextstep.ladder.utils.LadderValidation;

import java.util.Objects;

public class Point {

    private boolean left;
    private boolean right;

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

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public static Point last(boolean left) {
        return new Point(left, false);
    }

    public static Point next(Point previousPoint, boolean right) {
        if (previousPoint.isRight()) {
            return new Point(previousPoint.isRight(), false);
        }
        return new Point(false, right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left &&
                right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

}
