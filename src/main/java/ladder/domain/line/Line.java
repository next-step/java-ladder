package ladder.domain.line;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import ladder.domain.point.Point;
import ladder.exception.LadderGameException;

public class Line {

    private static final String INVALID_LADDER_POSITION = "사다리 좌표가 잘못 되었습니다.";
    private static final int START_INDEX = 0;

    private final LinkedList<Point> points;

    Line() {
        this.points = new LinkedList<>();
    }

    //for Test
    public Line(LinkedList<Point> points) {
        this.points = points;
    }

    public boolean addPoint(Point point) {
        if (!points.isEmpty()) {
            validateWithNextPoint(points.getLast(), point);
        }
        return points.add(point);
    }

    public Point getLastPoint() {
        return points.getLast();
    }

    public LinkedList<Point> getPoints() {
        return points;
    }

    private void validatePoints(List<Point> points) {
        Point now = points.get(START_INDEX);

        for (int i = 1; i < points.size(); i++) {
            Point next = points.get(i);
            validateWithNextPoint(now, next);
            now = next;
        }
    }

    private void validateWithNextPoint(Point now, Point next) {
        if (now.isRightDirection() && !next.isLeftDirection()) {
            throw new LadderGameException(INVALID_LADDER_POSITION);
        }
        if (!now.isRightDirection() && next.isLeftDirection()) {
            throw new LadderGameException(INVALID_LADDER_POSITION);
        }
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
