package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static final Line of(List<Point> points) {
        return new Line(points);
    }

    public static final Line of(int countPerson) {
        return of(generatePoints(countPerson));
    }

    private static final List<Point> generatePoints(int countPerson) {
        Random random = new Random();
        return IntStream.range(0, countPerson)
                .mapToObj(i -> random.nextBoolean())
                .map(Point::of)
                .collect(Collectors.toList());
    }

}
