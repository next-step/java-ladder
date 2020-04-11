package nextstep.ladder.domain;

import nextstep.ladder.domain.direction.Direction;
import nextstep.ladder.domain.direction.strategy.RandomMovement;

import java.util.Objects;

/**
 * LadderLine의 두 점과 현재 위치를 Point로 추상화
 * LadderLine에서 위치와 각 점의 방향을 관리
 */
public class Point {
    private static final int MOVE_ONE = 1;
    private static final int FIRST_POSITION = 0;

    private final int linePosition;
    private final Direction direction;

    public Point(int linePosition, Direction direction) {
        validateLinePosition(linePosition);

        this.linePosition = linePosition;
        this.direction = direction;
    }

    private void validateLinePosition(int linePosition) {
        if (linePosition < 0) {
            throw new IllegalArgumentException("라인 위치는 음수가 될수 없습니다.");
        }
    }

    public static Point of(int linePosition, Direction direction) {
        return new Point(linePosition, direction);
    }

    public static Point first() {
        return new Point(FIRST_POSITION, Direction.right(new RandomMovement()));
    }

    public static Point middle(Point point) {
        return new Point(point.getLinePosition() + MOVE_ONE, point.direction.next());
    }

    public static Point last(Point point) {
        return new Point(point.getLinePosition() + MOVE_ONE, point.direction.last());
    }

    public Direction getDirection() {
        return direction;
    }

    public int getLinePosition() {
        return linePosition;
    }

    public int move() {
        if(direction.isLeft()) {
            return linePosition - MOVE_ONE;
        }

        if(direction.isRight()) {
            return linePosition + MOVE_ONE;
        }

        return linePosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return linePosition == point.linePosition &&
                Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linePosition, direction);
    }
}
