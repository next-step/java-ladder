package ladder.model;

import ladder.exception.InvalidLineException;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        validate(points);
        this.points = points;
    }

    public static Line create(List<Point> points) {
        return new Line(points);
    }

    public static Line of(int width, int height, GenerationStrategy generationStrategy) {
        List<Point> points = new ArrayList<>();
        Point point = Point.createForFirstLine(height, generationStrategy);
        points.add(point);

        for (int index = 1; index < width - 1; index++) {
            Point currentPoint = Point.createComparingPrevPoint(height, point, generationStrategy);
            points.add(currentPoint);
            point = currentPoint;
        }

        points.add(Point.createForLastLine(height, point));
        return create(points);
    }

    private void validate(List<Point> points) {
        for (int index = 0; index < points.size() - 1; index++) {
            boolean prevConnection = points.get(index).isRight();
            boolean nowConnection = points.get(index + 1).isRight();

            if (prevConnection && nowConnection) {
                throw new InvalidLineException();
            }
        }
    }

    public List<Point> getPoints() {
        return points;
    }
}
