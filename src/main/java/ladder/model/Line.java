package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public Line of(int width, int height, GenerationStrategy generationStrategy) {
        List<Point> points = new ArrayList<>();
        Point point = Point.createForFirstLine(height, generationStrategy);
        points.add(point);

        for (int index = 1; index < width; index++) {
            Point currentPoint = Point.createComparingPrevPoint(height, point, generationStrategy);
            points.add(currentPoint);
            point = currentPoint;
        }

        points.add(Point.createForLastLine(height, point));
        return create(points);
    }

    private Line create(List<Point> points) {
        return new Line(points);
    }

}
