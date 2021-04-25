/*
 * 각 위치와 연결방향정보를 지니는 클래스
 * */
package step4.laddergame.domain.ladder;

import java.util.Objects;

public class Point {
    private static final int INIT_INDEX = 0;
    private static final int MOVE_INDEX = 1;
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(Boolean right) {
        return new Point(INIT_INDEX, Direction.first(right));
    }

    public int move() {
        if (direction.isRight()) {
            return index + MOVE_INDEX;
        }
        if (direction.isLeft()) {
            return index - MOVE_INDEX;
        }
        return index;
    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point next(LadderPointerGenerator generator) {
        return new Point(index + 1, direction.next(generator));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }

}
