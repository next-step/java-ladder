package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

import java.util.Objects;

public class Point {
    private boolean currentPoint;
    private boolean nextPoint;

    private Point(boolean currentPoint, boolean nextPoint) {
        this.currentPoint = currentPoint;
        this.nextPoint = nextPoint;
    }

    public static Point first() { // 가로 Line 처음 Point 값 지정
        return new Point(false, RandomUtil.generate());
    }

    public static Point last() { // 가로 Line 마지막 Point 값 지정
        return new Point(RandomUtil.generate(), false);
    }

    public static Point random() { // 현재 값이 false 이면 다음 값은 랜덤
        return new Point(false, RandomUtil.generate());
    }

    public static Point of() {
        return new Point(true, false); // 현재 값이 true 이면 다음 값은 무조건 false 이다.
    }


    public boolean currentPoint() {
        return currentPoint;
    }

    public boolean nextPoint() {
        return nextPoint;
    }

    public int move() {
        if (currentPoint) {
            return -1; // 왼쪽
        }
        if (nextPoint) {
            return 1; // 오른쪽
        }
        return 0; // 아래로 이동
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
