package ladder.domain.ladder.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ladder.domain.ladder.point.Point;
import ladder.domain.ladder.point.PointGenerator;

public class RandomLineGenerator implements LineGenerator {

    private final PointGenerator pointGenerator;

    public RandomLineGenerator(PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
    }

    @Override
    public Line generate(int numberOfPoints) {
        if (numberOfPoints == 1) {
            return Line.of(Collections.singletonList(Point.first(false)));
        }
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initMiddle(numberOfPoints, points, point);
        initLast(points, point);
        return Line.of(points);
    }

    private void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private Point initMiddle(int numberOfPoints, List<Point> points, Point point) {
        while (points.size() < numberOfPoints - 1) {
            point = point.next(pointGenerator);
            points.add(point);
        }
        return point;
    }

    private Point initFirst(List<Point> points) {
        Point point = Point.first(pointGenerator);
        points.add(point);
        return point;
    }
}
