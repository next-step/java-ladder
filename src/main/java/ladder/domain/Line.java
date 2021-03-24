package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int MIN_POINT_COUNT = 1;

    private final List<Point> pointList;

    private Line(List<Point> pointList) {
        validatePointListSize(pointList);
        validateInvalidPointList(pointList);
        this.pointList = pointList;
    }

    private void validateInvalidPointList(List<Point> pointList) {
        for (int i = 1; i < pointList.size(); i++) {
            Point previousPoint = pointList.get(i - 1);
            Point currentPoint = pointList.get(i);
            validateDirectionOf(previousPoint, currentPoint);
        }
    }

    private void validateDirectionOf(Point previousPoint, Point currentPoint) {
        if (previousPoint.hasRightDirection() != currentPoint.hasLeftDirection()) {
            throw new IllegalArgumentException("연속된 point의 우측방향과 좌측방향이 다를수 없습니다.");
        }
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
        for (int i = 0; i < pointCount - 2; i++) {
            Point previousPoint = pointList.get(pointList.size() - 1);
            pointList.add(previousPoint.next());
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


    public void validatePointListSize(List<Point> pointList) {
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
        int pointIndex = currentPosition.number();
        validateIndexRange(pointIndex);
        int movableIndex = pointList.get(pointIndex).movableIndex();
        return new Position(movableIndex);
    }

    private void validateIndexRange(int pointIndex) {
        if (pointIndex < 0 || pointIndex > pointListSize() - 1) {
            throw new IllegalArgumentException("범위를 벗어나는 position 입니다.");
        }
    }

}
