package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    private static final int FIRST_POINT_COUNT = 1;
    private static final int LAST_POINT_COUNT = 1;

    public Line generate(int count) {
        List<Point> initPoints = new ArrayList<>();

        PointGenerator pointGenerator = new PointGenerator(initPoints);
        Point point = pointGenerator.first();
        Point lastBodyPoint = pointGenerator.body(bodyCount(count), point);
        pointGenerator.last(lastBodyPoint);

        return new Line(initPoints);
    }

    private int bodyCount(int count) {
        return count - (FIRST_POINT_COUNT + LAST_POINT_COUNT);
    }
}
