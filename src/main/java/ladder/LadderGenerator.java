package ladder;

public class LadderGenerator {
    public static Direction generate(Point point, Point previousPoint) {
        if (point.isFirst()) {
            return generate(new FirstElementStrategy(point));
        }
        if (point.isLast()) {
            return generate(new LastElementStrategy(point, previousPoint));
        }
        return generate(new BodyElementStrategy(point, previousPoint));
    }

    private static Direction generate(LadderStrategy strategy) {
        return strategy.direction();
    }
}
