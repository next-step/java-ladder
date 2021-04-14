package ladder.factories;

import ladder.domain.LadderLine;
import ladder.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLineFactory {
    private static final Random random = new Random();

    public static LadderLine from(int width) {
        final List<Point> points = new ArrayList<>();

        Point prevPoint = Point.COMMON;

        for (int i = 0; i < width; i++) {
            final Point currentPoint = nextPoint(prevPoint, i == width - 1);

            points.add(currentPoint);

            prevPoint = currentPoint;
        }

        return new LadderLine(points);
    }

    private static Point nextPoint(Point prevPoint, boolean last) {
        if (prevPoint == Point.BEGIN) {
            return Point.END;
        }

        if (last) {
            return Point.COMMON;
        }

        return BeginOrCommon();
    }

    private static Point BeginOrCommon() {
        return random.nextInt(10) > 5 ? Point.BEGIN : Point.COMMON;
    }
}
