package nextstep.ladder.fixture;

import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.PointsGenerateStrategy;

import java.util.ArrayList;
import java.util.List;

public class RightOnlyPointsStrategy implements PointsGenerateStrategy<List<Boolean>> {

    @Override
    public List<Point> generate(List<Boolean> pointParam) {
        List<Point> points = new ArrayList<>();

        Point point = Point.first(pointParam.get(0));
        points.add(point);

        for (int i = 1; i < pointParam.size() - 1; i++) {
            Point nextPoint = Point.next(point.current(), pointParam.get(i));
            points.add(nextPoint);
            point = nextPoint;
        }

        point = Point.last(point.current());
        points.add(point);

        return points;
    }

}
