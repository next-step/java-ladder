package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final int STARTING_POINT = 0;
    private List<Point> points;

    public Line(int size) {
        this.generate(size);
    }

    public void generate(int size) {
        points = new ArrayList<>();
        IntStream.range(0, size)
            .forEach(i -> this.points.add(fillCurrent(i)));
    }

    private Point fillCurrent(int position) {
        if (position == STARTING_POINT)
            return new Point(false);

        Point randomPoint = Point.generateRandom();

        if (isOverlap(this.points.get(position - 1), randomPoint)) {
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
}
