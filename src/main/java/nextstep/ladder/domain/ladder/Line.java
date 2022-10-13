package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static nextstep.ladder.domain.ladder.Point.DEFAULT_POSITION;

public class Line {
    private static final String POINT_CONNECTED_EXCEPTION_MESSAGE = "점이 이어져 있습니다.";
    private static final String POINTS_SIZE_EXCEPTION_MESSAGE = "하나의 선은 점이 2개 이상이어야 합니다.";
    private static final int MIN_SIZE = 2;


    private final List<Point> points;

    public static Line create(int countOfPlayer, EnablePointStrategy strategy) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(DEFAULT_POSITION, strategy.isEnable()));

        IntStream.range(DEFAULT_POSITION + 1, countOfPlayer + 1)
                .forEach(i -> addNewPoint(points, i, strategy));

        return new Line(points);
    }

    private static void addNewPoint(List<Point> points, int index, EnablePointStrategy strategy) {
        if (isPreviousPointEnable(points, index)) {
            points.add(Point.of(index, () -> false));
            return;
        }

        points.add(Point.of(index, strategy));
    }

    private static boolean isPreviousPointEnable(List<Point> points, int index) {
        return points.get(index - 2).isEnable();
    }

    public Line(List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(List<Point> points) {
        points = new ArrayList<>(points);
        if (isValidSize(points)) {
            throw new IllegalArgumentException(POINTS_SIZE_EXCEPTION_MESSAGE);
        }

        Point prevPoint = points.remove(0);
        for (Point point : points) {
            prevPoint = getPointIfNotConnected(point, prevPoint);
        }
    }

    private static boolean isValidSize(List<Point> points) {
        return points.size() < MIN_SIZE;
    }

    private Point getPointIfNotConnected(Point point, Point prevPoint) {
        if (point.isConnected(prevPoint)) {
            throw new IllegalArgumentException(POINT_CONNECTED_EXCEPTION_MESSAGE);
        }

        return point;
    }

    public List<Point> points() {
        return Collections.unmodifiableList(points);
    }
}
