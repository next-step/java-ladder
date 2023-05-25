package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static List<Point> generatePoints(Supplier<Point> pointSupplier, int width) {
        List<Point> points = new ArrayList<>();
        for (int index = 0; index < width; index++) {
            addPoint(points, pointSupplier.get());
        }
        return points;
    }

    private static void addPoint(List<Point> points, Point point) {
        points.add(point);
    }

    public List<Point> getPoints() {
        return points;
    }
    
}
