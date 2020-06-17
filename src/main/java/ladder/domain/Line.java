package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line valueOf(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        Random random = new Random();
        Point point = Point.valueOf(false);
        while (countOfPerson > 0) {
            point = addLine(points, random, point);
            countOfPerson--;
        }
        return new Line(points);
    }

    private static Point addLine(List<Point> points, Random random, Point point) {
        points.add(point);
        point = point.checkOverlap(random.nextBoolean());
        return point;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
