package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineGenerator implements LineGenerator {

    private static final Random random = new Random();

    @Override
    public Line generateLine(int width) {

        List<Point> points = new ArrayList<>();
        initializePoints(points, width);

        return new Line(points);
    }
    private void initializePoints(List<Point> points, int width) {
        Point first = Point.first(random.nextBoolean());
        points.add(first);
        initializePointsNext(first, points, width);
    }

    private void initializePointsNext(Point first, List<Point> points, int width) {
        for (int i = 0; i < width -2; i++) {
            first = first.next(random.nextBoolean());
            points.add(first);
        }
        initializeLast(first, points);
    }

    private void initializeLast(Point first, List<Point> points) {
        Point last = first.last(random.nextBoolean());
        points.add(last);
    }
}
