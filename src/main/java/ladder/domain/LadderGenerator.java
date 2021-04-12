package ladder.domain;

public class LadderGenerator {
    public static Direction generate(Point point, Point previousPoint) {
        if (point.isFirst()) {
            return generate(new FirstElementStrategy());
        }
        if (point.isLast()) {
            return generate(new LastElementStrategy(previousPoint));
        }
        return generate(new BodyElementStrategy(previousPoint));
    }

    private static Direction generate(LadderStrategy strategy) {
        return strategy.direction();
    }
}
