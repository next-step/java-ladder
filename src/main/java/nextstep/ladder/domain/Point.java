package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

import java.util.Objects;

public class Point {
    private static final int RIGHT = 1;
    private static final int LEFT = -1;
    private static final int PASS = 0;
    private boolean currentPoint;
    private boolean nextPoint;

    private Point(boolean currentPoint, boolean nextPoint) {
        if (currentPoint && nextPoint) {
            throw new IllegalArgumentException("유효한 사다리가 아닙니다.");
        }
        this.currentPoint = currentPoint;
        this.nextPoint = nextPoint;
    }

    public static Point init(boolean nextPoint) { // 가로 Line 처음 Point 값 지정
        return new Point(false, nextPoint);
    }

    public Point last() { // 가로 Line 마지막 Point 값 지정
        return new Point(this.nextPoint, false);
    }

    public Point next() {
        if (this.nextPoint) {
            return next(false);
        }
        return next(RandomUtil.generate());
    }

    public Point next(boolean nextPoint) {
        if (this.nextPoint) {
            return new Point(this.nextPoint, false);
        }
        return new Point(this.nextPoint, nextPoint);
    }

    public boolean currentPoint() {
        return currentPoint;
    }

    public boolean nextPoint() {
        return nextPoint;
    }

    public int move() {
        if (currentPoint) {
            return LEFT; // 왼쪽
        }
        if (nextPoint) {
            return RIGHT; // 오른쪽
        }
        return PASS; // 아래로 이동
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return currentPoint == point.currentPoint && nextPoint == point.nextPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPoint, nextPoint);
    }
}
