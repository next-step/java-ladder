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
    private static final int LAST_POSITION_CHECK_INDEX = 2;

    private final Direction direction;
    private final int currentPosition;

    private Point(int currentPosition, Direction direction) {
        this.currentPosition = currentPosition;
        this.direction = direction;
    }

    static Point first() {
        return new Point(FIRST_POSITION, Direction.first());
    }

    Point next(boolean nextPoint, int maxPosition) {
        if (direction.isNextFalse(nextPoint) || isNextPositionLast(maxPosition)) {
            return new Point(currentPosition + INCREASE, direction.next(false));
        }

        return new Point(currentPosition + INCREASE, direction.next(nextPoint));
    }

    LadderBridge pointToBridge() {
        return LadderBridge.findLadderBridge(direction.isPoint(), isFirst(this.currentPosition, FIRST_POSITION));
    }

    private boolean isFirst(int currentPosition, int firstPosition) {
        return currentPosition == firstPosition;
    }

    public int move() {
        return this.currentPosition + direction.move();
    }

    private boolean isNextPositionLast(int maxPosition) {
        return maxPosition == this.currentPosition + LAST_POSITION_CHECK_INDEX;
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
