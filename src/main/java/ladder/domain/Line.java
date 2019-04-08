package ladder.domain;

import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public int lineCount() {
        return points.size();
    }

    public boolean hasHorizontalLine(int index) {
        return points.get(index).hasHorizontalLine();
    }


}
