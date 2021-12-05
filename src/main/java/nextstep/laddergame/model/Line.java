package nextstep.laddergame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import nextstep.laddergame.utils.RandomUtils;

public class Line {

    private static final int BOOLEAN_LIMIT = 2;

    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        points.add(makeRandomPoint());
        IntStream.range(1, countOfPerson - 1)
                 .forEach(index -> addPoint(index, points));
    }

    private void addPoint(int index, List<Point> points) {
        if (mustEmpty(index)) {
            points.add(Point.empty());
            return;
        }
        points.add(makeRandomPoint());
    }

    private Point makeRandomPoint() {
        return new Point(RandomUtils.generate(BOOLEAN_LIMIT));
    }

    private boolean mustEmpty(int index) {
        return points.get(index - 1).exist();
    }

    public List<Point> getPoints() {
        return points;
    }
}
