package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line create(List<Point> points) {
        return new Line(points);
    }

    public static Line of(int width, GenerateStrategy generateStrategy) {
        List<Point> points = new ArrayList<>();
        Point prevPoint = Point.createPointForFirstLine(generateStrategy);
        points.add(prevPoint);

        int count = 1;
        while (count < width - 1) {
            Point currentPoint = Point.createPointForMiddleLines(prevPoint, generateStrategy);
            points.add(currentPoint);
            prevPoint = currentPoint;
            count++;
        }

        Point pointForLastLine = Point.createPointForLastLine(prevPoint);
        points.add(pointForLastLine);

        return Line.create(points);
    }

    public List<Point> getPoints() {
        return points;
    }
}
