package nextstep.ladder.domain;

import nextstep.ladder.util.RandomGenerator;

import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-11 20:43
 */
class Point {

    private static final int INCREASE = 1;
    private static final int FIRST_POSITION = 0;
    private final boolean point;
    private final int currentPosition;

    private Point(int currentPosition, boolean point) {
        this.currentPosition = currentPosition;
        this.point = point;
    }

    static Point first() {
        return new Point(FIRST_POSITION, false);
    }

    Point next() {
        boolean nextPoint = RandomGenerator.generateBoolean();

        if (this.point && nextPoint) {
            return new Point(currentPosition + INCREASE, false);
        }

        return new Point(currentPosition + INCREASE, nextPoint);
    }

    LadderBridge pointToBridge() {
        if (this.point) {
            return LadderBridge.BRIDGE;
        }

        return LadderBridge.EMPTY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return this.point == point.point &&
                currentPosition == point.currentPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, currentPosition);
    }
}
