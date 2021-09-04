package ladder.domain.ladder;

import static ladder.domain.ladder.Point.createFirst;
import static ladder.domain.ladder.Point.createLast;
import static ladder.domain.ladder.Point.createNextByBeforePoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import ladder.strategy.LineGenerateStrategy;

public class Line {

    private static final int START_POINTS_INDEX = 1;
    private static final int ONE = 1;
    private static final int TWO = 2;

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line generateRandomLine(int userCount, LineGenerateStrategy lineGenerateStrategy) {
        List<Point> points = new ArrayList<>();

        points.add(createFirst(lineGenerateStrategy));
        IntStream.rangeClosed(START_POINTS_INDEX, userCount - TWO)
            .forEach(
                index -> points.add(createNextByBeforePoint(points.get(getBeforeIndex(index)), lineGenerateStrategy)));
        points.add(createLast(getLastPoint(points)));
        return new Line(points);
    }

    private static int getBeforeIndex(int index) {
        return index - ONE;
    }

    private static Point getLastPoint(List<Point> points) {
        return points.get(points.size() - ONE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

}
