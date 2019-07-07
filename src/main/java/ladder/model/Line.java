package ladder.model;

import ladder.utils.StatusGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints(){
        return Collections.unmodifiableList(points);
    }

    public static Line lineSet(int countOfPerson) {
        List<Point> tempPoints = new ArrayList <>();
        Point point = createFirst(tempPoints);
        point = createBody(countOfPerson, tempPoints, point);
        createLast(tempPoints, point);
        return new Line(tempPoints);
    }

    private static Point createFirst(List<Point> tempPoints) {
        Point point = Point.first(StatusGenerator.get());
        tempPoints.add(point);
        return point;
    }

    private static Point createBody(int countOfPerson, List<Point> tempPoints, Point point) {
        for (int i = 1; i < countOfPerson - 1; i++) {
            point = point.next();
            tempPoints.add(point);
        }
        return point;
    }

    private static void createLast(List<Point> tempPoints, Point point) {
        tempPoints.add(point.last());
    }

}
