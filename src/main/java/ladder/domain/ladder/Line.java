package ladder.domain.ladder;

import java.util.List;

public class Line {
    private static final int SECOND_INDEX = 1;

    private final List<Point> points;

    public Line(List<Point> points) {
        validateLine(points);

        this.points = points;
    }

    private void validateLine(List<Point> points) {
        for (int i = SECOND_INDEX; i < points.size(); i++) {
            Point previous = points.get(i - 1);
            Point current = points.get(i);

            checkCrossDuplicated(previous, current);
        }
    }

    private void checkCrossDuplicated(Point previous, Point current) {
        if (previous.isCross() && current.isCross()) {
            throw new IllegalArgumentException("Horizontal cross line is duplicated.");
        }
    }
}
