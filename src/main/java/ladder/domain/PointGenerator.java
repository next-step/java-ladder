package ladder.domain;

import java.util.List;

public class PointGenerator {
    private final List<PointNew> pointsNew;

    public PointGenerator(List<PointNew> pointsNew) {
        this.pointsNew = pointsNew;
    }

    public static Direction generate(Point point, Point previousPoint) {
        if (point.isFirst()) {
            return generate(new FirstPointStrategy());
        }
        if (point.isLast()) {
            return generate(new LastPointStrategy(previousPoint));
        }
        return generate(new BodyPointStrategy(previousPoint));
    }

    private static Direction generate(PointStrategy strategy) {
        return strategy.direction();
    }

    public PointNew first() {
        PointNew firstPoint = generate2(new FirstPointStrategy());
        pointsNew.add(firstPoint);
        return firstPoint;
    }

    public PointNew body(int count, PointNew firstPoint) {
        PointNew previousPoint = firstPoint;
        for (int i = 0; i < count; i++) {
            PointNew currentPoint = generate2(new BodyPointStrategy(previousPoint));
            pointsNew.add(currentPoint);
            previousPoint = currentPoint;
        }
        return previousPoint;
    }

    public PointNew last(PointNew previousPoint) {
        PointNew lastPoint = generate2(new LastPointStrategy(previousPoint));
        pointsNew.add(lastPoint);
        return lastPoint;
    }

    private PointNew generate2(PointStrategy pointStrategy) {
        return pointStrategy.point();
    }
}
