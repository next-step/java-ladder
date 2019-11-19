package ladder.domain;

import java.util.*;

public class LineShuffleGenerator implements LineGenerator {

    private static final int LADDER_BOUND_INDEX = 1;
    private static final int POINT_LAST_INDEX = 1;

    public LineShuffleGenerator() {
    }

    @Override
    public Line generate(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        points.add(generateShufflePoint());
        for (int i = LADDER_BOUND_INDEX; i < countOfPerson - POINT_LAST_INDEX; i++) {
            Point currentPoints = points.stream()
                    .skip(points.size() - POINT_LAST_INDEX)
                    .map(this::checkPoint)
                    .findFirst()
                    .orElse(generateShufflePoint());
            points.add(currentPoints);
        }
        points.add(new Point(false));
        return new Line(points);
    }

    private Point checkPoint(Point point) {
        if (point.getType()) {
            return new Point(Boolean.FALSE);
        }
        return generateShufflePoint();
    }

    private Point generateShufflePoint() {
        return new Point(new Random().nextBoolean());
    }

}
