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

    public static Point first(boolean next) {
        return new Point(FIRST_POSITION, Direction.first(next));
    }

    public Point next() {
        return new Point(positionIncrementAndGet(), direction.next());
    }

    public Point next(boolean next) {
        return new Point(positionIncrementAndGet(), direction.next(next));
    }

    public Point last() {
        return new Point(positionIncrementAndGet(), direction.last());
    }

    public int move() {
        return this.currentPosition + direction.move();
    }

    private int positionIncrementAndGet() {
        return this.currentPosition + INCREASE;
    }

    public boolean isPoint() {
        return direction.isPoint();
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
