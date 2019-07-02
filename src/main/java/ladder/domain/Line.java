package ladder.domain;

import ladder.domain.generator.PointGenerator;
import ladder.domain.generator.RandomPointGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int FIRST = 1;
    private final PointGenerator pointGenerator;
    private List<Point> points;

    public Line(int width) {

        this(width, new RandomPointGenerator());
    }

    public Line(int width, PointGenerator pointGenerator) {

        this.pointGenerator = pointGenerator;
        this.points = drawPoints(width);
    }

    private List<Point> drawPoints(int width) {

        List<Point> points = new ArrayList<>();
        points.add(Point.first(pointGenerator.generate()));
        IntStream.range(FIRST, width - 1)
                .mapToObj(position -> Point.middle(position, getLastPoint(points).getDirection(), pointGenerator.generate()))
                .forEach(points::add);
        points.add(Point.last(width - 1, getLastPoint(points).getDirection()));
        return points;
    }

    private Point getLastPoint(List<Point> points) {

        return points.get(points.size() - 1);
    }

    public List<Point> getPoints() {

        return points;
    }
}