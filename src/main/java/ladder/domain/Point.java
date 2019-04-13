package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Point {
    private static final List<Point> points = new ArrayList<>();
    private static final Map<Integer, Point> pointsM = new HashMap<>();
    private static final int INT_MOVE = 1;
    private static final String EMPTY_LINE = "     ";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final int MAX_INDEX = 10;
    private final int index;
    private final Direction direction;

    static {
        for(int i = 0; i < MAX_INDEX; i++) {
            Direction direction1 = Direction.of(false, false);
            Direction direction2 = Direction.of(false, true);
            Direction direction3 = Direction.of(true, false);

            Point point = new Point(i, direction1);
            Point point2 = new Point(i, direction2);
            Point point3 = new Point(i, direction3);
            pointsM.put(direction1.hashCode() + i, point);
            pointsM.put(point2.hashCode() + i, point2);
            pointsM.put(point3.hashCode() + i, point3);
        }
    }

    public static Point of(int index, Direction direction) {
        return pointsM.getOrDefault(direction.hashCode() + index, new Point(index, direction));
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

    public Point next(BooleanGenerator booleanGenerator) {
        return Point.of(index + INT_MOVE, direction.next(booleanGenerator));
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
