package ladder.domain;

import java.util.List;

public class PointGenerator {
    private final List<Point> points;

    public PointGenerator(List<Point> points) {
        this.points = points;
    }

    public Point first() {
        Point firstPoint = generate(new FirstPointStrategy());
        points.add(firstPoint);
        return firstPoint;
    }

    public Point body(int count, Point firstPoint) {
        Point previousPoint = firstPoint;
        for (int i = 0; i < count; i++) {
            Point currentPoint = generate(new BodyPointStrategy(previousPoint));
            points.add(currentPoint);
            previousPoint = currentPoint;
        }
        return previousPoint;
    }

    public void last(Point previousPoint) {
        Point lastPoint = generate(new LastPointStrategy(previousPoint));
        points.add(lastPoint);
    }

    private Point generate(PointStrategy pointStrategy) {
        return pointStrategy.point();
    }
}
