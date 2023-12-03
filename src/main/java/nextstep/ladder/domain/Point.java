package nextstep.ladder.domain;

import java.util.Arrays;

public enum Point {

    LINE(true), NOTHING(false);

    private final boolean pointStatus;

    Point(boolean pointStatus) {
        this.pointStatus = pointStatus;
    }

    public static Point valueOf(boolean pointStatus) {
        return Arrays.stream(values())
                .filter(point -> point.pointStatus == pointStatus)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("상태에 맞는 적잘한 수평선을 찾을 수 없습니다."));
    }

    public boolean isOverlapping(Point point) {
        return this.pointStatus && point.pointStatus;
    }

    public boolean pointStatus() {
        return pointStatus;
    }

    public Point createNonOverlappingPoint(boolean tempPointStatus) {
        if (this.pointStatus) {
            return Point.NOTHING;
        }
        return Point.valueOf(tempPointStatus);
    }
}
