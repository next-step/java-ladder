package ladder;

public class LadderGenerator {
    public static String generate(Point point, Point previousPoint) {
        if (point.isFirst()) {
            return generate(new FirstElementStrategy(point));
        }
        if (point.isLast()) {
            return generate(new LastElementStrategy(point, previousPoint));
        }
        return generate(new BodyElementStrategy(point, previousPoint));
    }

    private static String generate(LadderStrategy strategy) {
        return strategy.direction();
    }
}
