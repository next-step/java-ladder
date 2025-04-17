package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PointFactory {
    private PointFactory() {
    }

    public static List<Point> create(int countOfPlayer, PointStrategy strategy) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(strategy.shouldDraw());
        points.add(point);
        for (int i = 1; i < countOfPlayer - 1; i++) {
            boolean nextDraw = canDraw(point, strategy);
            point = point.next(nextDraw);
            points.add(point);
        }
        points.add(point.last());
        return points;
    }

    private static boolean canDraw(Point prev, PointStrategy strategy) {
        if (prev.canDrawNext()) {
            return strategy.shouldDraw();
        }
        return false;
    }
}
