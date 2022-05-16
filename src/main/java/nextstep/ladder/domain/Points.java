package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {
    private static final Random RANDOM = new Random();
    public static final int START_INCLUSIVE = 0;
    public static final int LAST_SIZE = 1;

    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public static Points of(Members members) {
        return new Points(toPoints(members, RANDOM));
    }

    private static List<Point> toPoints(Members members, Random random) {
        List<Point> points = new ArrayList<>();
        IntStream.range(START_INCLUSIVE, members.size() - LAST_SIZE)
                .forEach(setPoints(random, points));

        return points;
    }

    private static IntConsumer setPoints(Random random, List<Point> points) {
        return i -> {
            if (previousHasEdge(points, i)) {
                points.add(new Point(false));
                return;
            }

            points.add(Point.of(random));
        };
    }

    private static boolean previousHasEdge(List<Point> points, int i) {
        if (points.isEmpty()) {
            return false;
        }

        return points.get(i - LAST_SIZE)
                .isTrue();
    }

    public static Points of(List<Boolean> points) {
        return new Points(toPointList(points));
    }

    private static List<Point> toPointList(List<Boolean> points) {
        return points.stream()
                .map(Point::new)
                .collect(Collectors.toList());
    }

    public String getPoint() {
        return this.points.stream()
                .map(Point::getEdgeOrEmpty)
                .collect(Collectors.joining());
    }

}
