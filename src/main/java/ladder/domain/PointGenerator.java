package ladder.domain;

import java.util.List;

public class PointGenerator {
    private final List<Point> pointsNew;

    public PointGenerator(List<Point> pointsNew) {
        this.pointsNew = pointsNew;
    }

    public Point first() {
        Point firstPoint = generate2(new FirstPointStrategy());
        pointsNew.add(firstPoint);
        return firstPoint;
    }

    public Point body(int count, Point firstPoint) {
        Point previousPoint = firstPoint;
        for (int i = 0; i < count; i++) {
            Point currentPoint = generate2(new BodyPointStrategy(previousPoint));
            pointsNew.add(currentPoint);
            previousPoint = currentPoint;
        }
        return previousPoint;
    }

    public Point last(Point previousPoint) {
        Point lastPoint = generate2(new LastPointStrategy(previousPoint));
        pointsNew.add(lastPoint);
        return lastPoint;
    }

    private Point generate2(PointStrategy pointStrategy) {
        return pointStrategy.point();
    }
}
