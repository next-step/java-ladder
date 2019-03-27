package laddergame.domain;

import laddergame.util.StringUtils;

import static laddergame.domain.LadderLine.LADDER_LINE_STRING;
import static laddergame.validator.EndPointValidator.PARTICIPANT_MAXIMUM_NAME_LENGTH;

public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
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

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    @Override
    public String toString() {
        return "|" + StringUtils.repeat(direction.isToRight() ? LADDER_LINE_STRING : " ", PARTICIPANT_MAXIMUM_NAME_LENGTH);
    }
}