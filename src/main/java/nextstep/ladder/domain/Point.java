package nextstep.ladder.domain;

import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-11 20:43
 */
class Point {

    private static final int INCREASE = 1;
    private static final int FIRST_POSITION = 0;
    private final Direction direction;
    private final int currentPosition;

    private Point(int currentPosition, Direction direction) {
        this.currentPosition = currentPosition;
        this.direction = direction;
    }

    static Point first() {
        return new Point(FIRST_POSITION, Direction.first());
    }

    Point next(boolean nextPoint) {
        if (direction.isPoint() && nextPoint) {
            return new Point(currentPosition + INCREASE, direction.next(false));
        }

        return new Point(currentPosition + INCREASE, direction.next(nextPoint));
    }

    LadderBridge pointToBridge() {
        if (direction.isPoint()) {
            return LadderBridge.BRIDGE;
        }

        return LadderBridge.EMPTY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return currentPosition == point.currentPosition &&
                Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, currentPosition);
    }
}
