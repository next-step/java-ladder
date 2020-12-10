package ladder.domain;

import ladder.ladderexceptions.InvalidLayoutException;

public class Point {
    private final boolean leftSideStatus;
    private final boolean atStatus;

    public Point(boolean leftSideStatus, boolean atPointStatus) {
        validateStatus(leftSideStatus, atPointStatus);
        this.leftSideStatus = leftSideStatus;
        this.atStatus = atPointStatus;
    }

    private void validateStatus(boolean leftSideStatus, boolean atPointStatus) {
        if (leftSideStatus && atPointStatus) {
            throw new InvalidLayoutException();
        }
    }
}
