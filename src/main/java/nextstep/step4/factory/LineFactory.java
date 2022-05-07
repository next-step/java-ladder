package nextstep.step4.factory;

import nextstep.step4.domain.Point;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;
import static nextstep.step4.util.LadderPointGenerator.*;

public class LineFactory extends Factory {

    private final List<Point> points = new ArrayList<>();

    @Override
    protected Point drawFirstPoint() {
        Point firstPoint = Point.first(generateDirection());
        points.add(firstPoint);
        return firstPoint;
    }

    @Override
    protected Point drawMiddlePoints(int countOfPlayer, Point currentPoint) {
        for (int i = 1; i < countOfPlayer - 1; i++) {
            currentPoint = currentPoint.next();
            points.add(currentPoint);
        }
        return currentPoint;
    }

    @Override
    protected List<Point> drawLastPoint(Point currentPoint) {
        Point lastPoint = currentPoint.last();
        points.add(lastPoint);
        return unmodifiableList(points);
    }
}

