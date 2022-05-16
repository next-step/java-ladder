package ladder.domain;

import ladder.pattern.ValueGenerateStrategy;

import java.util.ArrayList;
import java.util.List;

import static ladder.domain.Point.FIRST_POSITION;
import static ladder.domain.Point.UNIT_HORIZONTAL_LINE_LENGTH;

public class Line {
    private static final int MIN_WIDTH = 2;

    private final List<Point> points;

    public Line(List<Point> points) {
        validatePoints(points);
        this.points = points;
    }

    public static Line create(int width, ValueGenerateStrategy valueGenerateStrategy) {
        validateWidth(width);
        List<Point> points = new ArrayList<>();
        Point point = Point.first(valueGenerateStrategy.booleanGenerate());
        points.add(point);
        for (int index = FIRST_POSITION + UNIT_HORIZONTAL_LINE_LENGTH; index < width - UNIT_HORIZONTAL_LINE_LENGTH; index++) {
            point = point.next(valueGenerateStrategy.booleanGenerate());
            points.add(point);
        }
        points.add(point.last());
        return new Line(points);
    }

    public List<Point> points() {
        return points;
    }

    public void validatePoints(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("라인을 구성하는 포인트들은 null 일 수 없습니다.");
        }
        validateWidth(points.size());
        validateDirectionAndPosition(points);
    }

    private void validateDirectionAndPosition(List<Point> points) {
        int width = points.size();
        Point firstPoint = points.get(FIRST_POSITION);
        firstPoint.validateFirstPoint();

        Point previousPoint = firstPoint;
        for (int index = UNIT_HORIZONTAL_LINE_LENGTH; index < width - UNIT_HORIZONTAL_LINE_LENGTH; index++) {
            Point currentPoint = points.get(index);
            currentPoint.validateMiddlePoint(previousPoint);
            previousPoint = currentPoint;
        }

        Point lastPoint = points.get(width - UNIT_HORIZONTAL_LINE_LENGTH);
        lastPoint.validateLastPoint(width);
    }

    private static void validateWidth(int width) {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException(String.format("라인의 폭은 2보다 작을 수 없습니다. (현재 라인 폭 : %d)", width));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return points.equals(line.points);
    }

    @Override
    public int hashCode() {
        return points.hashCode();
    }
}
