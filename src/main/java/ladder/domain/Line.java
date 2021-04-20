package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int MIN_POINT_COUNT = 2;
    private static final int FIRST_MIDDLE_POINT_INDEX = 1;

    private final List<Point> points;

    public Line(int pointCount) {
        this(new RandomLineWriteStrategy(), pointCount);
    }

    public Line(LineWriteStrategy lineWriteStrategy, int pointCount) {
        this(generatePoints(lineWriteStrategy, pointCount));
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    private static List<Point> generatePoints(LineWriteStrategy lineWriteStrategy, int pointCount) {
        validateLineWriteStrategy(lineWriteStrategy);
        validatePointCount(pointCount);
        List<Point> points = new ArrayList<>();
        points.add(generateFirstPoint(lineWriteStrategy));
        points.addAll(generateMiddlePoints(points.get(Point.FIRST_INDEX), lineWriteStrategy, pointCount));
        points.add(generateLastPoint(points));
        return points;
    }

    private static void validateLineWriteStrategy(LineWriteStrategy lineWriteStrategy) {
        if (lineWriteStrategy == null) {
            throw new IllegalArgumentException("라인 쓰기 형식을 입력해 주세요.");
        }
    }

    private static void validatePointCount(int pointCount) {
        if (pointCount < MIN_POINT_COUNT) {
            throw new IllegalArgumentException("라인 생성을 위해서는 최소 두 개의 점이 필요합니다.");
        }
    }

    private static Point generateFirstPoint(LineWriteStrategy lineWriteStrategy) {
        return Point.first(lineWriteStrategy.write());
    }

    private static List<Point> generateMiddlePoints(Point firstPoint, LineWriteStrategy lineWriteStrategy, int pointCount) {
        List<Point> middlePoints = new ArrayList<>();
        Point middlePoint = firstPoint;
        for (int i = FIRST_MIDDLE_POINT_INDEX; i < pointCount - 1; i++) {
            middlePoint = middlePoint.next(lineWriteStrategy.write());
            middlePoints.add(middlePoint);
        }
        return middlePoints;
    }

    private static Point generateLastPoint(List<Point> points) {
        return points.get(points.size() - 1).last();
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public int getLinkPointIndex(int index) {
        if (isInvalidIndex(index)) {
            throw new IllegalArgumentException("유효하지 않은 인덱스 입니다.");
        }
        return points.get(index).move();
    }

    private boolean isInvalidIndex(int index) {
        return index < Point.FIRST_INDEX || index >= points.size();
    }

}
