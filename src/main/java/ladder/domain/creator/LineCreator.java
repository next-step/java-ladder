package ladder.domain.creator;

import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.strategy.LineGenerateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class LineCreator {

    public static final int START_INCLUSIVE = 0;
    public static final int ONE = 1;

    private static final class LineCreatorHolder {
        private static final LineCreator instance = new LineCreator();
    }

    private LineCreator() {
    }

    public static final LineCreator getInstance() {
        return LineCreatorHolder.instance;
    }

    public final Line create(int countOfPerson, LineGenerateStrategy strategy) {
        List<Point> points = new ArrayList<>();
        points.add(Point.first());
        IntStream.range(START_INCLUSIVE, countOfPerson - ONE)
                .forEach(beforeIndex -> points.add(generatePoint(points.get(beforeIndex), strategy)));
        return Line.of(points);
    }

    private final Point generatePoint(Point before, LineGenerateStrategy strategy) {
        if (before.hasPoint()) {
            return Point.of(Boolean.FALSE);
        }
        return Point.of(strategy.generateLine());
    }

}
