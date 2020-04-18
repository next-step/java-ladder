package ladder;

import java.util.List;

public class LadderLine {
    private final List<Point> points;

    public static LadderLine from(PointGenerator pointGenerator) {
        return new LadderLine(pointGenerator.generate());
    }

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int pointIndex) {
        return points.get(pointIndex).move();
    }
}
