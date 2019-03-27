package ladder.domain.ladder;

import java.util.List;

public class Line {
    private static final int SECOND_INDEX = 1;

    private final List<Point> points;

    public Line(List<Point> points) {
        if (!isValidLine(points)) {
            throw new IllegalArgumentException("Horizontal cross lines are duplicated");
        }

        this.points = points;
    }

    private boolean isValidLine(List<Point> points) {
        for (int i = SECOND_INDEX; i < points.size(); i++) {
            Point previous = points.get(i - 1);
            Point current = points.get(i);

            if (checkCrossDuplicated(previous, current)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCrossDuplicated(Point previous, Point current) {
        return ((Point.CROSS == previous) && (Point.CROSS == current));
    }
}
