package ladder.domain.ladder;

import ladder.domain.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson, LineStrategy lineStrategy) {
        List<Point> points = new ArrayList<>();
        IntStream.range(0, countOfPerson).forEach(i ->
                points.add(getPoint(lineStrategy, hasPreviousLine(points, i), isLastPoint(countOfPerson, i)))
        );
        return new Line(points);
    }

    private static boolean isLastPoint(int countOfPerson, int index) {
        return index == countOfPerson - 1;
    }

    private static boolean hasPreviousLine(List<Point> points, int index) {
        return index != 0 && points.get(index - 1).hasLine();
    }

    private static Point getPoint(LineStrategy lineStrategy, boolean hasPreviousLine, boolean isLastPoint) {
        if (isLastPoint) {
            return new Point(false);
        }
        return Point.of(hasPreviousLine, lineStrategy);
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
