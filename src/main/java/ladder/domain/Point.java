package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Point {
    private static final int INT_MOVE = 1;
    private static final String EMPTY_LINE = "     ";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final int MAX_INDEX = 10;
    private static final Map<Integer, Point> points = new HashMap<>();
    private final int index;
    private final DirectionType directionType;

    static {
        for(int i = 0; i < MAX_INDEX; i++) {
            DirectionType directionType1 = DirectionType.of(false, false);
            DirectionType directionType2 = DirectionType.of(false, true);
            DirectionType directionType3 = DirectionType.of(true, false);

            Point point = new Point(i, directionType1);
            Point point2 = new Point(i, directionType2);
            Point point3 = new Point(i, directionType3);
            points.put(directionType1.hashCode() + i, point);
            points.put(directionType2.hashCode() + i, point2);
            points.put(directionType3.hashCode() + i, point3);
        }
    }

    public static Point of(int index, DirectionType directionType) {
        return points.getOrDefault(directionType.hashCode() + index, new Point(index, directionType));
    }

    private Point(int index, DirectionType directionType) {
        this.index = index;
        this.directionType = directionType;
    }

    public int move() {
        if(directionType.isRight()) {
            return index + INT_MOVE;
        }
        if(directionType.isLeft()) {
            return index - INT_MOVE;
        }
        return this.index;
    }

    public Point next(BooleanGenerator booleanGenerator) {
        return Point.of(index + INT_MOVE, directionType.next(booleanGenerator));
    }

    public Point next(Boolean right) {
        return Point.of(index + INT_MOVE, directionType.next(right));
    }

    public static Point first(Boolean right) {
        return Point.of(0, DirectionType.first(right));
    }

    public Point last() {
        return Point.of(index + INT_MOVE, directionType.last());
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(VERTICAL_LINE);
        if(directionType.isRight()) {
            stringBuffer.append(HORIZONTAL_LINE);
        }
        if(directionType.isLeft()) {
            stringBuffer.append(EMPTY_LINE);
        }
        if(directionType.isCenter()) {
            stringBuffer.append(EMPTY_LINE);
        }

        return stringBuffer.toString();
    }
}
