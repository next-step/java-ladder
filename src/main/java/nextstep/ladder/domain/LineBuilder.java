package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineBuilder {

    private static final Random RANDOM = new Random();

    private final List<Point> points = new ArrayList<>();

    public static Line buildWithRandomPoints(int count) {
        return new LineBuilder().initRandomMoveablePoint()
                .addRandomMoveablePoints(count - 2)
                .build();
    }

    private Line build() {
        points.add(lastPoint().createRightmost());
        return new Line(points);
    }

    private LineBuilder addRandomMoveablePoints(int numberOfMiddlePoints) {
        for (int i = 0; i < numberOfMiddlePoints; i++) {
            Point point = lastPoint().createNext(RANDOM.nextBoolean());
            points.add(point);
        }
        return this;
    }

    private LineBuilder initRandomMoveablePoint() {
        points.add(Point.createLeftmost(RANDOM.nextBoolean()));
        return this;
    }

    private Point lastPoint() {
        return points.get(points.size() - 1);
    }
}
