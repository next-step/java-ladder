package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final int STARTING_POINT = 0;
    private List<Point> points;

    public Line(int size) {
        this.points = new ArrayList<>(size);
        this.generate();
    }

    public List<Point> generate() {
        IntStream.range(0, points.size())
            .forEach(i -> this.points.add(fillCurrent(i)));

        return this.points;
    }

    private Point fillCurrent(int position) {
        if (position == STARTING_POINT)
            return new Point(false);

        Point randomPoint = Point.generateRandom();

        if (isSameBefore(points.get(position), randomPoint)) {
            return Point.reverse(randomPoint);
        }

        return randomPoint;
    }

    static boolean isSameBefore(Point beforeBoolean, Point randomBoolean) {
        return Point.isEqual(beforeBoolean, randomBoolean);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        points.forEach(point -> builder.append(point.beautify()).append("|"));
        return builder.toString();
    }
}
