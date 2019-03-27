package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private static final int SECOND_INDEX = 1;
    private static final String BOUNDARY = "|";

    private final List<Point> points;

    public Line(List<Point> points) {
        if (!isValidLine(points)) {
            throw new IllegalArgumentException("Horizontal cross lines are duplicated");
        }

        this.points = points;
    }

    // TODO indent 제거
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

    @Override
    public String toString() {
        return this.points.stream()
                .map(Point::toString)
                .collect(Collectors.joining(BOUNDARY, BOUNDARY, BOUNDARY));
    }
}
