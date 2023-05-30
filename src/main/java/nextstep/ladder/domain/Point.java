package nextstep.ladder.domain;

import nextstep.ladder.dto.PointDto;

public class Point {
    private boolean left;
    private boolean right;

    private Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public Point next(boolean right) {
        boolean beforeRight = this.right;
        if (beforeRight) {
            right = false;
        }
        return new Point(beforeRight, right);
    }

    public Point last() {
        boolean beforeRight = this.right;
        return new Point(beforeRight, false);
    }

    public Direction getDirection() {
        if (right) {
            return Direction.RIGHT;
        }
        if (left) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    public PointDto toDto() {
        return new PointDto(left, right);
    }

}
