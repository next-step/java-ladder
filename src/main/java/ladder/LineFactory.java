package ladder;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {
    public static Line create(int countOfPersons, PointStrategy strategy) {
        List<Point> points = new ArrayList<>();

        Point first = Point.first(strategy.generate());
        points.add(first);

        Point prev = first;
        for (int i = 1; i < countOfPersons - 1; i++) {
            boolean nextPoint = validate(prev, strategy.generate());
            Point next = prev.next(nextPoint);
            points.add(next);
            prev = next;
        }

        points.add(prev.last());
        return new Line(points);
    }

    private static boolean validate(Point prev, boolean nextDirection) {
        return (!prev.isCurrent() || !nextDirection) && nextDirection;
    }
}
