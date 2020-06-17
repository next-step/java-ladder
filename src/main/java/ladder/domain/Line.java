package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line valueOf(int countOfPerson, PointGenerator pointGenerator) {
        List<Point> points = new ArrayList<>();
        Point point = Point.stop();
        while (countOfPerson > 0) {
            point = addLine(points, pointGenerator, point);
            countOfPerson--;
        }
        return new Line(points);
    }

    private static Point addLine(List<Point> points, PointGenerator pointGenerator, Point point) {
        points.add(point);
        point = point.checkOverlap(pointGenerator.generate());
        return point;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
