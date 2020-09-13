package nextstep.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private static final int START_INDEX = 1;
    private static final Random RANDOM = new Random();
    private final List<Point> points = new ArrayList<>();

    private Line(int personnel) {
        points.add(Point.getStartPoint(RANDOM.nextBoolean()));
        IntStream.range(START_INDEX, personnel - 1)
                .forEach(index -> points.add(getCurrentLastPoint().next(RANDOM.nextBoolean())));
        points.add(getCurrentLastPoint().getLastPoint());
    }

    private Line() {
        points.add(Point.getSinglePoint());
    }

    private Point getCurrentLastPoint() {
        return points.get(points.size() - 1);
    }

    public List<Boolean> getPedalsStatus() {
        return this.points.stream()
                .map(Point::hasLeftPedal)
                .collect(Collectors.toList());
    }

    public int play(int index) {
        Point point = points.get(index);
        return point.play(index);
    }

    public static Line of(int personnel) {
        if (personnel == 1) {
            return new Line();
        }
        return new Line(personnel);
    }
}
