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

    public static void validatePoints(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("라인을 구성하는 포인트들은 null 일 수 없습니다.");
        }
        validateWidth(points.size());
        validateDirectionAndPosition(points);
    }

    private static void validateDirectionAndPosition(List<Point> points) {
        int width = points.size();
        Point firstPoint = points.get(FIRST_POSITION);
        validateFirstPoint(firstPoint);

        Point previousPoint = firstPoint;
        for (int index = UNIT_HORIZONTAL_LINE_LENGTH; index < width - UNIT_HORIZONTAL_LINE_LENGTH; index++) {
            Point currentPoint = points.get(index);
            validateMiddlePoint(previousPoint, currentPoint);
            previousPoint = currentPoint;
        }

        Point lastPoint = points.get(width - UNIT_HORIZONTAL_LINE_LENGTH);
        validateLastPoint(lastPoint, width);
    }

    private static void validateFirstPoint(Point firstPoint) {
        validateFirstPointDirection(firstPoint);
        validateFirstPointPosition(firstPoint);
    }

    private static void validateMiddlePoint(Point previousPoint, Point currentPoint) {
        validateMiddlePointDirection(previousPoint, currentPoint);
        validateMiddlePointPosition(previousPoint, currentPoint);
    }

    private static void validateLastPoint(Point lastPoint, int width) {
        validateLastPointDirection(lastPoint);
        validateLastPointPosition(lastPoint, width);
    }

    private static void validateFirstPointDirection(Point firstPoint) {
        if (firstPoint.isLeft()) {
            throw new IllegalArgumentException(String.format("첫번째 포인트는 왼쪽 방향일 수 없습니다. 입력받은 포인트 : %s", firstPoint));
        }
    }

    private static void validateFirstPointPosition(Point firstPoint) {
        if (!firstPoint.isFirstPosition()) {
            throw new IllegalArgumentException(String.format("첫번째 포인트는 position 이 0 이여야 합니다. 입력받은 포인트 : %s", firstPoint));
        }
    }

    private static void validateMiddlePointDirection(Point previousPoint, Point currentPoint) {
        if ((previousPoint.isLeft() && currentPoint.isLeft())
                || previousPoint.isStraight() && currentPoint.isLeft()
                || previousPoint.isRight() && !currentPoint.isLeft()) {
            throw new IllegalArgumentException(String.format("이전 포인트와 현재 포인트의 방향이 잘못 되었습니다. 입력받은 이전 포인트 : %s 현재 포인트 : %s", previousPoint, currentPoint));
        }
    }

    private static void validateMiddlePointPosition(Point previousPoint, Point currentPoint) {
        if (!previousPoint.isPreviousPoint(currentPoint)) {
            throw new IllegalArgumentException(String.format("이전 포인트와 현재 포인트의 position 차이는 1 이여야 합니다. 입력받은 이전 포인트 : %s 현재 포인트 : %s", previousPoint, currentPoint));
        }
    }

    private static void validateLastPointDirection(Point lastPoint) {
        if (lastPoint.isRight()) {
            throw new IllegalArgumentException(String.format("마지막 포인트는 오른쪽 방향일 수 없습니다. 입력받은 포인트 : %s", lastPoint));
        }
    }

    private static void validateLastPointPosition(Point lastPoint, int width) {
        if (lastPoint.isLastPosition(width)) {
            throw new IllegalArgumentException(String.format("마지막 포인트는 position 이 '라인 폭 - 1' (현재 라인 폭 - 1 : %d) 이여야 합니다. 입력받은 포인트 : %s", width - UNIT_HORIZONTAL_LINE_LENGTH, lastPoint));
        }
    }

    private static void validateWidth(int width) {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException(String.format("라인의 폭은 2보다 작을 수 없습니다. (현재 라인 폭 : %d)", width));
        }
    }
}
