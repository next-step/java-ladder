package ladder.domain;

import java.util.List;

public class Line {
    private final int heightPosition;
    private final List<Point> points;

    public Line(int heightPosition, List<Point> points) {
        this.heightPosition = heightPosition;
        this.points = points;
    }

    public boolean isEqualHeightPosition(int heightPosition) {
        return this.heightPosition == heightPosition;
    }

    public Point containsPoint(int index) {
        return this.points.stream()
                .filter(point -> point.isEqualIndex(index))
                .findFirst()
                .orElseGet(null);
    }
}
