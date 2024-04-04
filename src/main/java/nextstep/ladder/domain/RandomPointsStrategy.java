package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomPointsStrategy implements PointsGenerateStrategy<Integer> {

    @Override
    public List<Point> generate(Integer pointParam) {
        List<Point> points = new ArrayList<>();

        Point point = Point.first();
        points.add(point);

        for (int i = 1; i < pointParam - 1; i++) {
            Point nextPoint = Point.next(point.current());
            points.add(nextPoint);
            point = nextPoint;
        }

        point = Point.last(point.current());
        points.add(point);

        return points;
    }

}
