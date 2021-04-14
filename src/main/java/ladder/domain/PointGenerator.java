package ladder.domain;

public class PointGenerator {
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
}
