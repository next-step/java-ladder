package nextstep.ladder.domain.ladder;

import static nextstep.ladder.domain.ladder.Point.generatePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.generator.RandomPointGenerator;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        if(validAvailableLine(points)){
            throw new IllegalArgumentException("라인이 겹칩니다.");
        }
        this.points = points;
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    public static Line of(Boolean... points) {
        return new Line(
            Arrays.stream(points)
                .map(Point::of)
                .collect(Collectors.toList())
        );
    }

    public static Line generateLine(int userCount) {
        List<Point> points = new ArrayList<>();

        IntStream.range(0, userCount)
            .forEach(idx -> addAvailablePoint(points, idx));

        return Line.of(points);
    }

    private boolean validAvailableLine(List<Point> points) {
        return IntStream.range(0, points.size() - 1)
            .anyMatch(idx -> points.get(idx).isConnected() && points.get(idx + 1).isConnected());
    }

    private static void addAvailablePoint(List<Point> points, int idx) {
        if (idx == 0) {
            points.add(generatePoint(new RandomPointGenerator()));
        }

        if (!points.get(idx - 1).isConnected()) {
            points.add(generatePoint(new RandomPointGenerator()));
        }
    }

}
