package nextstep.ladder.codeleesh.domain;

import nextstep.ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CodeLineCreator implements LineCreator {

    private static final Random RANDOM = new Random();

    public CodeLineCreator() {}

    @Override
    public Line create(final int countOfPerson) {

        final List<Point> points = new ArrayList<>();
        final Point point = Point.first(generate());
        points.add(point);
        while (point.untilExcludeStart(points.size(), countOfPerson)) {
            points.add(nextPoint(points).next(generate()));
        }
        points.add(nextPoint(points).last());
        return new Line(points);
    }

    private static Point nextPoint(final List<Point> points) {

        return points.get(points.size() - 1);
    }

    private static boolean generate() {

        return RANDOM.nextBoolean();
    }
}
