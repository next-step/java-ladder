package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line createByRandomPoint(final int playerCount) {
        List<Point> points = new ArrayList<>();
        Point beforePoint = Point.create(new RandomPointCreationStrategy());
        points.add(beforePoint);

        for (int i = 1; i < playerCount - 1; i++) {
            beforePoint = getPoint(beforePoint);
            points.add(beforePoint);
        }
        return new Line(points);
    }

    private static Point getPoint(final Point point) {
        if (point == null || !point.isPoint()) {
            return Point.create(new RandomPointCreationStrategy());
        }

        return Point.create(false);
    }

    public List<Point> getPoints() {
        return points;
    }

    private Point getLastPoint() {
        final int lastIndex = points.size() - 1;
        return Point.create(points.get(lastIndex).isPoint());
    }

    @Override
    public String toString() {
        return "Line : " + points;
    }
}
