package step4.ladderGame.domain.ladder;

import step4.ladderGame.domain.ladder.pointGenerationStrategy.LadderLineGenerationStrategy;

import java.util.List;
import java.util.stream.IntStream;

public final class Line {

    private final List<Point> points;

    public Line(final int countOfPerson, final LadderLineGenerationStrategy ladderLineGenerationStrategy) {
        points = Point.generateFirstPoint();

        IntStream.range(0, countOfPerson - 2).forEach(
                index -> {
                    Point prePoint = points.get(index);
                    points.add(Point.generatePoint(prePoint, ladderLineGenerationStrategy));
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
