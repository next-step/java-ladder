package step3.ladderGame.domain.ladder;

import java.util.List;
import java.util.stream.IntStream;

public final class Line {

    private final List<Point> points;

    public Line(final int countOfPerson) {
        points = Point.generateFirstPoint();

        IntStream.range(0, countOfPerson - 2).forEach(
                index -> {
                    Point prePoint = points.get(index);
                    points.add(Point.generatePoint(prePoint));
                }
        );

        points.add(Point.generateLastPoint(points.get(points.size() - 1)));
    }

    public int move(final int index) {
        return points.get(index).move(index);
    }

    public List<Point> getPoints() {
        return points;
    }

}
