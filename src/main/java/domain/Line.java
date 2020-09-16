package domain;

import java.util.ArrayList;
import java.util.List;

import static utility.generatorPoint.makeDirection;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        Point point = makeFirstPoint();
        point = makeIntermediatePoint(countOfPerson, point);
        makeEndPoint(point);

    }

    private Point makeFirstPoint() {
        Point point = new Point(0, makeDirection());
        points.add(point);
        return point;
    }

    private Point makeIntermediatePoint(int countOfPerson, Point point) {
        Point newPoint;

        for (int i = 1; i < countOfPerson - 1; i++) {
            newPoint = point.next();
            points.add(newPoint);
            point = newPoint;
        }
        return point;
    }

    private void makeEndPoint(Point point) {
        points.add(point.last());
    }

    public List<Point> getPoints() {
        return points;
    }
}
