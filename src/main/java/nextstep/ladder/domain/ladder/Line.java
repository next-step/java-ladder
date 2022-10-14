package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final String POINT_OVERLAP_MESSAGE = "점이 연속해 이어져 있습니다.";
    private static final String POINTS_SIZE_EXCEPTION_MESSAGE = "선은 점이 1개 이상이어야 합니다.";
    private static final int MIN_SIZE = 1;

    private final List<Point> points;

    public static Line create(int countOfPoint, EnablePointStrategy strategy) {
        List<Point> points = new ArrayList<>();

        Point firstPoint = Point.first(strategy);
        points.add(firstPoint);

        if (countOfPoint == 1) {
            return new Line(points);
        }

        if (countOfPoint == 2) {
            points.add(Point.lastOf(firstPoint, strategy));
            return new Line(points);
        }

        for (int i = 1; i < countOfPoint - 1; i++) {
            Point prevPoint = points.get(i - 1);
            Point nextPoint = Point.nextOf(prevPoint, strategy);
            points.add(nextPoint);
        }

        Point lastPoint = Point.lastOf(points.get(points.size() - 1), strategy);
        points.add(lastPoint);

        return new Line(points);
    }


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
        return points.size() < MIN_SIZE;
    }

    private boolean isNotValidPoints(List<Point> points) {
        List<Point> target = new ArrayList<>(points);

        Point prevPoint = target.remove(0);
        for (Point point : target) {
            if (prevPoint.isOverlap(point)) {
                return true;
            }
            prevPoint = point;
        }

        return false;
    }

    public List<Point> points() {
        return Collections.unmodifiableList(points);
    }
}
