package ladder.domain;

import ladder.ladderexceptions.InvalidLayoutException;

import java.util.Arrays;

public enum PointStatus {
    LEFT(-1, true, false),
    RIGHT(1, false, true),
    PASS(0, false, false);

    private final int delta;
    private final boolean leftSideStatus;
    private final boolean atStatus;

    PointStatus(int delta, boolean leftSideStatus, boolean atStatus) {
        this.delta = delta;
        this.leftSideStatus = leftSideStatus;
        this.atStatus = atStatus;
    }

    public static PointStatus first(boolean atStatus) {
        return custom(false, atStatus);
    }

    public PointStatus next(boolean atStatus) {
        if (this == PointStatus.RIGHT) {
            return custom(this.atStatus, false);
        }

        return custom(this.atStatus, atStatus);
    }

    public PointStatus last() {
        return custom(this.atStatus, false);
    }

    public static PointStatus custom(boolean leftSideStatus, boolean atStatus) {
        return Arrays.stream(PointStatus.values())
                .filter(value -> value.leftSideStatus == leftSideStatus && value.atStatus == atStatus)
                .findAny()
                .orElseThrow(InvalidLayoutException::new);
    }

    public int nextIndex(int current) {
        return current + delta;
    }
}
