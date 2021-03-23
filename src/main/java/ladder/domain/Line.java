package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int MIN_POINT_COUNT = 1;

    private final List<Point> pointList;

    private Line(List<Point> pointList) {
        validatePointSize(pointList);
        this.pointList = pointList;
    }

    public static Line init(int pointCount) {
        List<Point> pointList = new ArrayList<>();
        initFirst(pointList);
        initBody(pointList, pointCount);
        initLast(pointList);
        return new Line(pointList);
    }

    private static void initFirst(List<Point> pointList) {
        pointList.add(Point.first());
    }

    private static void initBody(List<Point> pointList, int pointCount) {
        Point firstPoint = pointList.get(0);
        for (int i = 0; i < pointCount - 2; i++) {
            pointList.add(firstPoint.next());
        }
    }

    private static void initLast(List<Point> pointList) {
        Point middlePoint = pointList.get(pointList.size() - 1);
        pointList.add(middlePoint.last());
    }

    public static Line ofPointList(List<Point> pointList) {
        return new Line(pointList);
    }

    public static Line ofDirectionList(List<Direction> directionListInOrder) {
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < directionListInOrder.size(); i++) {
            pointList.add(new Point(i, directionListInOrder.get(i)));
        }
        return new Line(pointList);
    }


    public void validatePointSize(List<Point> pointList) {
        if (pointList.size() < MIN_POINT_COUNT) {
            throw new IllegalArgumentException("숫자가 너무 작습니다.");
        }
    }

    public List<Point> pointList() {
        return pointList;
    }

    public int pointListSize() {
        return pointList.size();
    }

    public Position nextPosition(Position currentPosition) {
        int movableIndex = pointList.get(currentPosition.number()).movableIndex();
        return new Position(movableIndex);
    }

}
