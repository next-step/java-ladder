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
        points.add(lastPoint().rightmostPoint());
        return new Line(points);
    }

    private LineBuilder addRandomMoveablePoints(int countOfMiddlePoint) {
        for (int i = 0; i < countOfMiddlePoint; i++) {
            Point point = lastPoint().nextPoint(RANDOM.nextBoolean());
            points.add(point);
        }
        return this;
    }

    private LineBuilder initRandomMoveablePoint() {
        points.add(Point.leftmostPoint(RANDOM.nextBoolean()));
        return this;
    }

    private Point lastPoint() {
        return points.get(points.size() - 1);
    }
}
