package game.ladder.domain;

import com.google.common.base.Preconditions;

public class Point {

    private static final String LINE = "-----";
    private static final String EMPTY = "     ";
    private static final String SEPRERATOR = "|";

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        Preconditions.checkArgument(index >= 0, "index는 음수 일 수 없습니다.");
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return new Point(0, Direction.first(right));
    }

    public int move() {
        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return this.index;
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

    public String getStringPoint(boolean last) {
        if (last) {
            return SEPRERATOR;
        }

        if (isFirst()) {
            return EMPTY + SEPRERATOR + getRightStringPoint();
        }

        return SEPRERATOR + getRightStringPoint();
    }

    private boolean isFirst() {
        return this.index == 0;
    }

    private String getRightStringPoint() {
        if (this.direction.isRight()) {
            return LINE;
        }

        return EMPTY;
    }
}
