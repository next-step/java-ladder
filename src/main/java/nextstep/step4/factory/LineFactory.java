package nextstep.step4.factory;

import nextstep.step4.domain.Point;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;
import static nextstep.step4.util.LadderPointGenerator.*;

public class LineFactory {

    private LineFactory() { }

    public static List<Point> create(int countOfPlayer) {
        List<Point> points = new ArrayList<>();
        Point currentPoint = drawFirstPoint(points);
        currentPoint = drawMiddlePoints(points, countOfPlayer, currentPoint);
        drawLastPoint(points, currentPoint);

        return unmodifiableList(points);
    }

    private static Point drawFirstPoint(List<Point> points) {
        Point firstPoint = Point.first(generateDirection());
        points.add(firstPoint);
        return firstPoint;
    }

    private static Point drawMiddlePoints(List<Point> points, int countOfPlayer, Point currentPoint) {
        for (int i = 1; i < countOfPlayer - 1; i++) {
            currentPoint = currentPoint.next();
            points.add(currentPoint);
        }
        return currentPoint;
    }

    private static void drawLastPoint(List<Point> points, Point currentPoint) {
        Point lastPoint = currentPoint.last();
        points.add(lastPoint);
    }
}

