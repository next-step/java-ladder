package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final int STARTING_POINT = 0;
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line generate(int height) {
        List<Point> generatedPoints = new ArrayList<>();
        IntStream.range(0, height)
            .forEach(i -> generatedPoints.add(fillCurrent(generatedPoints, i)));
        return new Line(generatedPoints);
    }

    private static Point fillCurrent(List<Point> generatedPoints, int position) {
        if (position == STARTING_POINT)
            return new Point(false);

        Point randomPoint = Point.generateRandom();

        if (isOverlap(generatedPoints.get(position - 1), randomPoint)) {
            return Point.reverse(randomPoint);
        }

        return randomPoint;
    }

    static boolean isOverlap(Point beforeBoolean, Point randomBoolean) {
        return Point.isTrueOverlap(beforeBoolean, randomBoolean);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        this.points.forEach(point -> builder.append(point).append("l"));
        return builder.toString();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
