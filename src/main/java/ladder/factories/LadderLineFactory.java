package ladder.factories;

import ladder.domain.LadderLine;
import ladder.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLineFactory {
    private static final Random random = new Random();

    public static LadderLine createAuto(int count) {
        final List<Point> points = new ArrayList<>();

        Point prevPoint = Point.COMMON;

        for (int i = 0; i < count; i++) {
            final Point currentPoint = autoCreatedPoint(prevPoint, i == count - 1);

            points.add(currentPoint);

            prevPoint = currentPoint;
        }

        return new LadderLine(points);
    }

    private static Point autoCreatedPoint(Point prevPoint, boolean last) {
        if (prevPoint == Point.BEGIN) {
            return Point.END;
        }

        if (last) {
            return Point.COMMON;
        }

        return randomValue() ? Point.BEGIN : Point.COMMON;
    }

    private static boolean randomValue() {
        return random.nextInt(10) > 5;
    }
}
