package ladderrefactoring.domain.ladder;

import ladderrefactoring.strategy.DirectionStrategy;

import java.util.*;

public class Line {

    public static final String EXIST_TRUE_REPETITION = "연속된 사다리가 존재 합니다.";

    private final List<Point> points = new ArrayList<>();

    public Line(int widthOfLadder, DirectionStrategy directionStrategy) {
        initLine(widthOfLadder, directionStrategy);
    }

    private void initLine(int widthOfLadder, DirectionStrategy directionStrategy) {
        Point currentPoint = Point.first(directionStrategy.create());
        points.add(currentPoint);

        for (int i = 0; i < widthOfLadder-1; i++) {
            currentPoint = Point.of(currentPoint, directionStrategy.create());
            points.add(currentPoint);
        }

        points.add(Point.last(currentPoint));
    }

    public List<Point> points() {
        return Collections.unmodifiableList(points);
    }

    public int movePosition(int currentPosition) {
        Point point = points.get(currentPosition);
        return point.move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
