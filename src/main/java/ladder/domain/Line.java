package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int MIN_POINT_COUNT = 2;
    private static final boolean EMPTY_LINE = false;
    private static final int FIRST_POINT_INDEX = 0;
    private static final int FIRST_MIDDLE_POINT_INDEX = 1;

    private final LineWriteStrategy lineWriteStrategy;
    private final List<Point> points;

    public Line(int pointCount) {
        this(new RandomLineWriteStrategy(), pointCount);
    }

    public Line(LineWriteStrategy lineWriteStrategy, int pointCount) {
        validatePointCount(pointCount);
        this.lineWriteStrategy = lineWriteStrategy;
        this.points = generatePointList(pointCount);
    }

    private void validatePointCount(int pointCount) {
        if (pointCount < MIN_POINT_COUNT) {
            throw new IllegalArgumentException("라인 생성을 위해서는 최소 두 개의 점이 필요합니다.");
        }
    }

    private List<Point> generatePointList(int pointCount) {
        List<Point> points = new ArrayList<>();
        points.add(generateFirstPoint());
        points.addAll(generateMiddlePoints(points.get(FIRST_POINT_INDEX), pointCount));
        points.add(generateLastPoint());
        return points;
    }

    private Point generateFirstPoint() {
        return generatePoint();
    }

    private List<Point> generateMiddlePoints(Point firstPoint, int pointCount) {
        List<Point> middlePoints = new ArrayList<>();
        Point middlePoint = firstPoint;
        for (int i = FIRST_MIDDLE_POINT_INDEX; i < pointCount - 1; i++) {
            middlePoint = generateMiddlePoint(middlePoint);
            middlePoints.add(middlePoint);
        }
        return middlePoints;
    }

    private Point generateMiddlePoint(Point currentPoint) {
        if (currentPoint.hasLine()) {
            return generateEmptyPoint();
        }
        return generatePoint();
    }

    private Point generateLastPoint() {
        return generateEmptyPoint();
    }

    private Point generatePoint() {
        return new Point(this.lineWriteStrategy.write());
    }

    private Point generateEmptyPoint() {
        return new Point(EMPTY_LINE);
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public int getLinkPointIndex(int index) {
        if (isInvalidIndex(index)) {
            throw new IllegalArgumentException("유효하지 않은 인덱스 입니다.");
        }
        if (isLinkedWithRight(index)) {
            return ++index;
        }
        if (isLinkedWithLeft(index)) {
            return --index;
        }
        return index;
    }

    private boolean isInvalidIndex(int index) {
        return index < FIRST_POINT_INDEX || index >= points.size();
    }

    private boolean isLinkedWithRight(int index) {
        return points.get(index).hasLine();
    }

    private boolean isLinkedWithLeft(int index) {
        return index >= MIN_POINT_COUNT && points.get(index - 1).hasLine();
    }
}
