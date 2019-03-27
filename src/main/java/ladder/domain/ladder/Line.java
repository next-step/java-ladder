package ladder.domain.ladder;

import ladder.vo.Length;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private static final int SECOND_INDEX = 1;
    private static final String BOUNDARY = "|";

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
        if (isCrossDuplicated(previous, current)) {
            throw new IllegalArgumentException("Horizontal cross lines are duplicated");
        }
    }

    private boolean isCrossDuplicated(Point previous, Point current) {
        return ((Point.CROSS == previous) && (Point.CROSS == current));
    }

    public Length getWidth() {
        return new Length(this.points.size());
    }

    @Override
    public String toString() {
        return this.points.stream()
                .map(Point::toString)
                .collect(Collectors.joining(BOUNDARY, BOUNDARY, BOUNDARY));
    }
}
