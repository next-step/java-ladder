package laddergame.domain;

import laddergame.service.LadderValueGenerator;
import laddergame.util.StringUtils;

import java.util.Objects;

import static laddergame.domain.EndPoint.PARTICIPANT_MAXIMUM_NAME_LENGTH;
import static laddergame.domain.LadderLine.LADDER_LINE_STRING;

public class Point {
    private final int index;
    private final Direction direction;

    protected Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int getIndex() {
        return index;
    }

    public int move() {
        if (direction.isToRight()) {
            return index + 1;
        }

        if (direction.isToLeft()) {
            return index - 1;
        }

        return index;
    }

/*
    public Point next() {
        return new Point(index + 1, direction.next());
    }
*/

    Point next(LadderValueGenerator ladderValueGenerator) {
        return new Point(index + 1, direction.next(ladderValueGenerator));
    }

    public Point next(Boolean toRight) {
        return new Point(index + 1, direction.next(toRight));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public static Point first(Boolean toRight) {
        return new Point(0, Direction.first(toRight));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index &&
                direction.equals(point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }

    @Override
    public String toString() {
        return "|" + StringUtils.repeat(direction.isToRight() ? LADDER_LINE_STRING : " ", PARTICIPANT_MAXIMUM_NAME_LENGTH);
    }
}