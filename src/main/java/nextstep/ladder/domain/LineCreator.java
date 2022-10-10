package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineCreator {

    private static final Random RANDOM = new Random();

    private LineCreator() {}

    public static Line create(final int countOfPerson) {

        final List<Point> points = new ArrayList<>();
        final Point point = Point.first(Movement.first(generate()));
        points.add(point);
        while (point.untilExcludeStart(points.size(), countOfPerson)) {
            points.add(nextPoint(points).next(generate()));
        }
        return new Line(points);
    }

    private static Point nextPoint(final List<Point> points) {

        return points.get(points.size() - 1);
    }

    private static boolean generate() {

        return RANDOM.nextBoolean();
    }
}
