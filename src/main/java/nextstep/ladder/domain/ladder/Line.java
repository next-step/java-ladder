package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final String POINT_OVERLAP_MESSAGE = "점이 연속해 이어져 있습니다.";
    private static final int MIN_POINTS_SIZE = 1;
    private static final String POINTS_SIZE_EXCEPTION_MESSAGE = "점이 " + MIN_POINTS_SIZE + "개 이상이어야 합니다.";

    private final List<Point> points;

    public Line(List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(List<Point> points) {
        if (isNotValidSize(points)) {
            throw new IllegalArgumentException(POINTS_SIZE_EXCEPTION_MESSAGE);
        }

        if (isNotValidPoints(points)) {
            throw new IllegalArgumentException(POINT_OVERLAP_MESSAGE);
        }
    }

    private boolean isNotValidSize(List<Point> points) {
        return points.size() < MIN_POINTS_SIZE;
    }

    private boolean isNotValidPoints(List<Point> points) {
        List<Point> target = new ArrayList<>(points);

        Point prevPoint = target.remove(0);
        for (Point point : target) {
            if (prevPoint.isOverlapping(point)) {
                return true;
            }
            prevPoint = point;
        }

        return false;
    }

    public static Line create(int countOfPoint, EnablePointStrategy strategy) {
        if (isZeroPoint(countOfPoint)) {
            return new Line(List.of());
        }

        if (isOnePoint(countOfPoint)) {
            return new Line(List.of(new Point(0, false, false)));
        }

        List<Point> points = initPoints(strategy);
        if (isTwoPoint(countOfPoint)) {
            points.add(Point.lastOf(points.get(0), strategy));
            return new Line(points);
        }

        setPoints(points, strategy, countOfPoint);
        return new Line(points);
    }

    private static boolean isZeroPoint(int countOfPoint) {
        return countOfPoint == 0;
    }

    private static boolean isOnePoint(int countOfPoint) {
        return countOfPoint == 1;
    }

    private static boolean isTwoPoint(int countOfPoint) {
        return countOfPoint == 2;
    }

    private static void setPoints(List<Point> points, EnablePointStrategy strategy, int countOfPoint) {
        for (int i = 1; i < countOfPoint - 1; i++) {
            Point prevPoint = points.get(i - 1);
            Point nextPoint = Point.nextOf(prevPoint, strategy);
            points.add(nextPoint);
        }

        Point lastPoint = Point.lastOf(points.get(points.size() - 1), strategy);
        points.add(lastPoint);
    }

    private static List<Point> initPoints(EnablePointStrategy strategy) {
        Point firstPoint = Point.first(strategy);
        return new ArrayList<>(List.of(firstPoint));
    }

    public Point findPoint(int pointPosition) {
        return points().get(pointPosition);
    }

    public List<Point> points() {
        return Collections.unmodifiableList(points);
    }
}
