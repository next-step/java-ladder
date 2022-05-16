package nextstep.ladder.domain.ladder;

import nextstep.ladder.util.ConnectStrategy;

import java.util.Objects;

public class Point {

    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        validateIndex(index);
        this.index = index;
        this.direction = direction;
    }

    private void validateIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("[ERROR] 사다리의 한 행의 위치는 0이상이어야 합니다.");
        }
    }

    public static Point of(int index, Direction direction) {
        return new Point(index, direction);
    }

    public static Point first(ConnectStrategy connectStrategy) {
        return new Point(0, Direction.first(connectStrategy));
    }

    public Point next(ConnectStrategy connectStrategy) {
        return new Point(index + 1, direction.next(connectStrategy));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
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

    @Override
    public String toString() {
        if (direction.isRight()) {
            return "|-----";
        }
        return "|     ";
    }
}
