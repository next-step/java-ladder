package ladder.domain;

import java.util.*;

public class LineShuffleGenerator implements LineGenerator {
    private static final int LADDER_BOUND_INDEX = 0;
    private static final int POINT_LAST_INDEX = 1;
    private static final List<Boolean> BOOLEANS = Arrays.asList(Boolean.TRUE, Boolean.FALSE);

    private int countOfPerson;

    public LineShuffleGenerator(int countOfPerson) {
        this.countOfPerson = countOfPerson;
    }

    @Override
    public Line generate() {
        List<Point> points = new ArrayList<>();
        for (int i = LADDER_BOUND_INDEX; i < this.countOfPerson - POINT_LAST_INDEX; i++) {
            Point currentPoints = points.stream()
                    .reduce((a, b) -> b)
                    .map(this::checkPoint)
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
        Collections.shuffle(BOOLEANS);
        boolean type = BOOLEANS.stream()
                .findAny()
                .orElse(Boolean.FALSE);

        return new Point(type);
    }

}
