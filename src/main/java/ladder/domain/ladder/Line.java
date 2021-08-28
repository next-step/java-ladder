package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class Line {

    private final List<Point> points;

    private Line(final List<Point> points) {
        this.points = points;
    }

    public static Line generate(final DirectionStrategy directionStrategy, final int rowCount) {
        List<Point> points = generatePoints(directionStrategy, rowCount);
        points.add(generateLastPoint(points));
        return new Line(points);
    }

    private static List<Point> generatePoints(final DirectionStrategy directionStrategy, final int rowCount) {
        List<Point> points = new ArrayList<>();
        points.add(Point.first(directionStrategy));
        IntStream.range(1, rowCount - 1)
                .mapToObj(ignore -> generatePoint(directionStrategy, points))
                .forEach(points::add);

        return points;
    }

    private static Point generatePoint(final DirectionStrategy directionStrategy, final List<Point> points) {
        return getLastPoints(points).next(directionStrategy);
    }

    private static Point generateLastPoint(final List<Point> points) {
        return getLastPoints(points).last();
    }

    private static Point getLastPoints(final List<Point> points) {
        return points.get(points.size() - 1);
    }

    public int move(final int position) {
        return points.get(position).move();
    }

    public List<Point> getPoints() {
        return points;
    }
}
