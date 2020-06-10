package ladder.domain;

import ladder.domain.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {

    public static final int MINIMUM_COUNT_OF_PERSON = 1;

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson, LineStrategy lineStrategy) {
        List<Point> points = new ArrayList<>();
        IntStream.range(0, countOfPerson).forEach(i -> {
            boolean hasPreviousLine = i != 0 && points.get(i - 1).hasLine();
            points.add(Point.of(hasPreviousLine, lineStrategy));
        });
        return new Line(points);
    }

    public Point get(int index) {
        return points.get(index);
    }

    public int size() {
        return points.size();
    }

    public Stream<Point> stream() {
        return points.stream();
    }
}
