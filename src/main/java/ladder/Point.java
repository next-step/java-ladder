package ladder;

import ladder.State.Direction;

import java.util.Objects;

public class Point {
    private final int index;
    private final State state;

    public Point(int index, State state) {
        this.index = index;
        this.state = state;
    }

    public int move() {
        Direction direction = state.move();
        return direction.move(index);
    }

    /**
     * first와 last Point가 아닌 Point를 의미하는가?
     * first와 last Point를 제외하다보니 2를 minus
     *
     * @param people
     * @return
     */
    public boolean untilBeforeLastPoint(int people) {
        return people - 2 > index;
    }

    public boolean isFirstAndLast(int people) {
        return index == 0 || index == people -1;
    }

    public Point next(Boolean current) {
        return new Point(index + 1, state.next(current));
    }

    public Point last() {
        return new Point(index + 1, state.last());
    }

    public static Point first(Boolean current) {
        return new Point(0, State.first(current));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index &&
                Objects.equals(state, point.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, state);
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", state=" + state +
                '}';
    }
}
