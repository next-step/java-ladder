package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ladder.model.Point.generatePoint;

public class LadderLine {
    private final List<Point> points;

    private LadderLine(final List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(final List<Point> points) {
        if (Objects.isNull(points) || points.isEmpty()) {
            throw new IllegalArgumentException("point count must be greater than zero.");
        }
    }

    public static LadderLine init(final int poleCount) {
        return init(PoleCount.of(poleCount));
    }

    public static LadderLine init(final PoleCount poleCount) {
        List<Point> points = new ArrayList<>();
        points.add(initFirst());
        points.addAll(initBody(poleCount, points.get(points.size() - 1)));
        points.add(initLast(points.get(points.size() - 1)));
        return new LadderLine(points);
    }

    private static Point initFirst() {
        return Point.first(generatePoint());
    }

    private static List<Point> initBody(final PoleCount poleCount, final Point firstPoint) {
        List<Point> bodyPoints = new ArrayList<>();
        Point prePoint = Point.of(firstPoint);

        for (int i = 1; i < poleCount.toInt() - 1; i++) {
            bodyPoints.add(prePoint.next());
            prePoint = bodyPoints.get(i - 1);
        }

        return bodyPoints;
    }

    private static Point initLast(final Point prePoint) {
        return prePoint.last();
    }

    public LadderPole move(final LadderPole position) {
        Point targetPoint = points.get(position.toInt());
        return targetPoint.move();
    }

    public int poleCount() {
        return points.size();
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
