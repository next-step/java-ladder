package ladder.model;

import ladder.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        validateLine(points);
        this.points = points;
    }

    private void validateLine(List<Point> points) {
        IntStream.range(0, points.size() - 1)
                .filter(i -> !points.get(i).validateRight(points.get(i+1)))
                .findFirst()
                .ifPresent(i -> {
                    throw new IllegalArgumentException("사다리를 생성할 수 없습니다.");
                });
    }

    public static Line create(int countOfUser, BooleanGenerator booleanGenerator) {
        List<Point> points = new ArrayList<>();

        Point point = Point.createFirst(booleanGenerator.generate());
        points.add(point);

        for (int i = 1; i < countOfUser - 1; i++) {
            point = point.createNext(booleanGenerator.generate());
            points.add(point);
        }
        points.add(point.createLast());

        return new Line(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
