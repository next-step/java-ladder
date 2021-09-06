package ladderrefactoring.domain.ladder;

import ladderrefactoring.strategy.DirectionStrategy;

import java.util.*;

public class Line {

    private static final int OFFSET_FIRST_AND_LAST = -2;

    private final List<Point> points = new ArrayList<>();

    public Line(int widthOfLadder) {
        initLine(widthOfLadder);
    }

    private void initLine(int widthOfLadder) {
        Point currentPoint = Point.first();
        points.add(currentPoint);

        for (int i = 0; i < widthOfLadder + OFFSET_FIRST_AND_LAST; i++) {
            currentPoint = currentPoint.next();
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
