package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Point {
    private static final List<Point> points = new ArrayList<>();
    private static final int INT_MOVE = 1;
    private static final String EMPTY_LINE = "     ";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final int MAX_INDEX = 50;
    private final int index;
    private final Direction direction;

    static {
        for(int i = 0; i < MAX_INDEX; i++) {
            points.add(new Point(i, Direction.of(false, true)));
            points.add(new Point(i, Direction.of(false, false)));
            points.add(new Point(i, Direction.of(true, false)));
        }
    }

    public static Point of(int index, Direction direction) {
        return new Point(index, direction);
    }

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if(direction.isRight()) {
            return index + INT_MOVE;
        }
        if(direction.isLeft()) {
            return index - INT_MOVE;
        }
        return this.index;
    }

    public Point next() {
        return Point.of(index + INT_MOVE, direction.next());
    }

    public Point next(Boolean right) {
        return Point.of(index + INT_MOVE, direction.next(right));
    }

    public static Point first(Boolean right) {
        return Point.of(0, Direction.first(right));
    }

    public Point last() {
        return Point.of(index + INT_MOVE, direction.last());
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(VERTICAL_LINE);
        if(direction.isRight()) {
            stringBuffer.append(HORIZONTAL_LINE);
        }
        if(direction.isLeft()) {
            stringBuffer.append(EMPTY_LINE);
        }
        if(direction.isCenter()) {
            stringBuffer.append(EMPTY_LINE);
        }

        return stringBuffer.toString();
    }
}
