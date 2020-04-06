package nextstep.ladder.domain;

public class Point {
    private boolean leftDirection;
    private boolean rightDirection;

    public Point() {
        this.leftDirection = false;
        this.rightDirection = false;
    }

    public boolean setRightDirection(boolean rightDirection) {
        if (rightDirection && this.leftDirection) {
            return false;
        }

        this.rightDirection = rightDirection;
        return true;
    }

    public boolean setLeftDirection(boolean leftDirection) {
        if (leftDirection && this.rightDirection) {
            return false;
        }

        this.leftDirection = leftDirection;
        return true;
    }

    public boolean hasRightDirection() {
        return rightDirection;
    }

    public boolean hasLeftDirection() {
        return leftDirection;
    }
}
