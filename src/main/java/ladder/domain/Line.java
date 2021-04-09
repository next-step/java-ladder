package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int MIN_POINT_COUNT = 2;
    private static final boolean EMPTY_LINE = false;

    private final List<Point> pointList;
    private final LineWriteStrategy lineWriteStrategy;

    public Line(int pointCount) {
        validatePointCount(pointCount);
        this.pointList = generatePointList(pointCount);
        this.lineWriteStrategy = new RandomLineWriteStrategy();
    }

    private void validatePointCount(int pointCount) {
        if (pointCount < MIN_POINT_COUNT) {
            throw new IllegalArgumentException("라인 생성을 위해서는 최소 두 개의 점이 필요합니다.");
        }
    }

    private List<Point> generatePointList(int pointCount) {
        List<Point> points = new ArrayList<>();
        Point currentPoint = generatePoint();
        points.add(currentPoint);
        for (int i = 1; i < pointCount - 1; i++) {
            currentPoint = generateMiddlePoint(currentPoint);
            points.add(currentPoint);
        }
        points.add(generateLastPoint());
        return points;
    }

    private Point generatePoint() {
        return new Point(lineWriteStrategy.write());
    }

    private Point generateMiddlePoint(Point currentPoint) {
        if(currentPoint.hasLine()) {
            return new Point(EMPTY_LINE);
        }
        return generatePoint();
    }

    private Point generateLastPoint() {
        return new Point(EMPTY_LINE);
    }

    public List<Point> getPointList() {
        return pointList;
    }
}
