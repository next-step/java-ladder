package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Point> points;

    private Line(int countOfPoints) {
        this.points = buildLadderColumn(countOfPoints);
    }

    public static Line valueOf(int countOfPoints) {
        return new Line(countOfPoints);
    }

    private List<Point> buildLadderColumn(int countOfPoints) {
        List<Point> points = new ArrayList<>();
        IntStream.range(0, countOfPoints)
                .forEach(point -> points.add(new Point()));
        return points;
    }

    public void draw(int position) {
        Point currentPoint = getCurrentPoint(position);
        Point nextPoint = getNextPoint(position);

        if (!canDrawLine(currentPoint, nextPoint)) {
            return;
        }
        currentPoint.makeOnRight();
        nextPoint.makeOnLeft();
    }

    public boolean hasLine(int position) {
        Point cur = getCurrentPoint(position);
        Point next = getNextPoint(position);
        return cur.hasRight() && next.hasLeft();
    }

    private boolean canDrawLine(Point current, Point next) {
        return current.canMake() && !next.hasLeft();
    }

    private Point getNextPoint(int position) {
        return points.get(position + 1);
    }

    private Point getCurrentPoint(int position) {
        return points.get(position);
    }

}
