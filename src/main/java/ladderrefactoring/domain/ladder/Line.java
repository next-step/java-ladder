package ladderrefactoring.domain.ladder;

import ladderrefactoring.strategy.DirectionStrategy;

import java.util.*;

public class Line {

    public static final int SECOND_INDEX = 1;

    private final List<Point> points = new ArrayList<>();

    public Line(int widthOfLadder, DirectionStrategy directionStrategy) {
        initLine(widthOfLadder, directionStrategy);
    }

    private void initLine(int widthOfLadder, DirectionStrategy directionStrategy) {
        Point currentPoint = Point.first(directionStrategy);
        points.add(currentPoint);

        for (int i = SECOND_INDEX; i < widthOfLadder-1; i++) {
            currentPoint = currentPoint.next(directionStrategy);
            points.add(currentPoint);
        }

        points.add(currentPoint.last());
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
