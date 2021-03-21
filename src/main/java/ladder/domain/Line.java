package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private static final int MIN_POINT_COUNT = 1;

    private final List<Point> pointList;

    private Line(List<Point> pointList) {
        validatePointSize(pointList);
        validateOverlapping(pointList);
        this.pointList = pointList;
    }

    public static Line random(int pointCount) {
        List<Point> randomPointList = new ArrayList<>();
        for (int i = 0; i < pointCount; i++) {
            randomPointList.add(randomPoint(randomPointList));
        }
        return new Line(randomPointList);
    }

    public static Line of(List<Point> pointList) {
        List<Point> copyOfPointList = pointList.stream()
                .map(point -> new Point(point.isFilled()))
                .collect(Collectors.toList());
        return new Line(copyOfPointList);
    }

    private static Point randomPoint(List<Point> pointList) {
        if (pointList.size() == 0) {
            return Point.emptyPoint();
        }
        Point previousPoint = pointList.get(pointList.size() - 1);
        if (previousPoint.isFilled()) {
            return Point.emptyPoint();
        }
        return Point.randomPoint();
    }

    public void validateOverlapping(List<Point> pointList) {
        for (int i = 1; i < pointList.size(); i++) {
            Point currentPoint = pointList.get(i);
            Point previousPoint = pointList.get(i - 1);
            if (previousPoint.isFilled() && currentPoint.isFilled()) {
                throw new IllegalArgumentException("가로줄이 겹칩니다.");
            }
        }
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

    public boolean isFilledAt(int index) {
        return point(index).isFilled();
    }

    public Point point(int index) {
        if(index < 0 || index > pointList.size()-1) {
            return Point.emptyPoint();
        }
        return pointList.get(index);
    }
}
